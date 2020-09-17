import { Component, OnInit, TemplateRef, ElementRef, ContentChild } from '@angular/core';
import { LocalDataSource } from 'ng2-smart-table';
import { NgbModal, ModalDismissReasons, NgbActiveModal } from '@ng-bootstrap/ng-bootstrap';
import { GroupService } from './group.service';
import { Group } from './group';
import { ToastrService } from '../common/nb-toastr.service';
import { NbToastStatus } from '@nebular/theme/components/toastr/model';

@Component({
  selector: 'group',
  templateUrl: './group.component.html',
  styleUrls: ['./group.component.scss']
})
export class GroupComponent implements OnInit {
  modalHeader: string="Group";
  formName:string="Create Group";
  mainPageName:string = "Group" 

  source: LocalDataSource = new LocalDataSource(); //this use for data table

  groupMainModel= new Group();

  constructor(private modalService: NgbModal,
    private _groupService:GroupService,
    private toastrService: ToastrService) {

    this.getAllGroups();
   }
   
   ngOnInit() {
   }

  public getAllGroups(){ //get all data main function
    this._groupService.getAllGroups().subscribe(data =>{
    var group:Group[] = new Array(data.length)  
     var count=1;
     data.forEach((groupObj) => { // foreach statement  
      groupObj.base64Image="data:image/PNG;base64,"+groupObj.imageData;
      group[count]=groupObj
      count++;
    })  
    this.source.load(group);
    });
  }

  selectedFiles: FileList;
  selected : boolean=false;
  fileUploadError: boolean=false;
  temporyImage:string="assets/images/default_image.gif";
  selectFile(event) {
    this.selectedFiles = event.target.files;
    this._groupService.showTemporyImage(this.selectedFiles.item(0)).subscribe(data=>{
      this.temporyImage="data:image/PNG;base64,"+data.imageData;
      console.info(this.temporyImage);
    });
  }

  public resetImage(){
    this.temporyImage="assets/images/default_image.gif";
  }

  currentFileUpload: File;
  public submitGroup(){
    if(this.selectedFiles){
      this.currentFileUpload = this.selectedFiles.item(0);
    }
    this._groupService.createAndUpdateGroup(this.groupMainModel,this.currentFileUpload).subscribe(data =>{
      this.activeModal.close();
      this.getAllGroups();
      if(this.groupMainModel.groupId)
        this.toastrService.showToast(NbToastStatus.SUCCESS,"Update","Update Success..!!");
      else
        this.toastrService.showToast(NbToastStatus.SUCCESS,"Create","Create Success..!!");
    })
  }

  public getGroupById(groupId:string){ // this is related to update process
    this._groupService.getGroupById(groupId).subscribe(data =>{
      this.groupMainModel.groupId=data.groupId;
      this.groupMainModel.group_name=data.group_name;
      this.groupMainModel.imageName=data.imageName;
      this.groupMainModel.imageData=data.imageData;
      if(data.imageData!=null)
        this.temporyImage="data:image/PNG;base64,"+data.imageData;
    });
  }

  public deleteGroup(groupId) {
    this._groupService.deleteGroup(groupId).subscribe(responce =>{
        if(responce.key=="success"){
          this.getAllGroups();
          this.toastrService.showToast(NbToastStatus.SUCCESS,"Delete",responce.message);
        }
    });
  }


  /******************************** model common function [start]********************************/
  
  closeResult: string;
  activeModal:any
  openLg(content) {
    this.activeModal=this.modalService.open(content, { size: 'lg' });
  }

  closeModal() {
    this.activeModal.close();
  }
  
  /******************************** model common function [end]********************************/
  /********************] data table configurationz [start] *[**********************************/
    settings = {
      mode: 'external',
      actions:{
        width: '20%',
        position: 'right',
      },
      add: {
        addButtonContent: '<i class="nb-plus"></i>',
        createButtonContent: '<i class="nb-checkmark"></i>',
        cancelButtonContent: '<i class="nb-close"></i>',
      },
      edit: {
        editButtonContent: '<i class="nb-edit"></i>',
        saveButtonContent: '<i class="nb-checkmark"></i>',
        cancelButtonContent: '<i class="nb-close"></i>',
        
      },
      delete: {
        deleteButtonContent: '<i class="nb-trash"></i>',
        confirmDelete: true,
      },
      
      columns: {
        base64Image: {
          title: 'Photo',
          type: 'html',
          width: '15%',
          
          valuePrepareFunction: (base64Image:string) => { return `<img alt="Avatar" class="image-col" src="${base64Image}">`; },
        },//${picture}
        /* id: {
          title: 'ID',
          type: 'number',
        }, */
        group_name: {
          title: 'Group Name',
          type: 'string',
        },
        /* lastName: {
          title: 'Last Name',
          type: 'string',
        },
        username: {
          title: 'Username',
          type: 'string',
        },
        email: {
          title: 'E-mail',
          type: 'string',
        },
        age: {
          title: 'Age',
          type: 'number',
        }, */
      },
    };

    onDeleteRowSelect($event){
      if (window.confirm('Are you sure you want to delete?')) {
        this.deleteGroup($event.data.groupId)
      } else {
      }
    }
  

    onAddRowSelect($event,content){
      this.groupMainModel= new Group()
      this.resetImage();
      this.openLg(content);
    }
    
    public onEditRowSelect($event,content){
      this.resetImage();
      this.getGroupById($event.data.groupId);
      this.openLg(content);
    }
    
  /********************] data table configurationz [end] *[**********************************/
}
