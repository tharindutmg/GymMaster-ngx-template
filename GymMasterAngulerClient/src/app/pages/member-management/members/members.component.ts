import { Component, OnInit } from '@angular/core';
import { NgbModal } from '@ng-bootstrap/ng-bootstrap';
import { Member } from './member';

@Component({
  selector: 'members',
  templateUrl: './members.component.html',
  styleUrls: ['./members.component.scss']
})
export class MembersComponent implements OnInit {

  modalHeader: string="Members";
  formName:string="Create Members";
  mainPageName:string = "Member List";

  membersModel= new Member();

  constructor(private modalService: NgbModal) { }

  ngOnInit() {
  }

  genderonclick(value:any){
    console.info(value)
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
        id: {
          title: 'ID',
          type: 'number',
        },
        firstName: {
          title: 'First Name',
          type: 'string',
        },
        lastName: {
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
        },
      },
    };
  
    
  
    onDeleteConfirm(event): void {
      if (window.confirm('Are you sure you want to delete?')) {
        event.confirm.resolve();
      } else {
        event.confirm.reject();
      }
    }
  
  
  
    public onEditRowSelect(event,content) { 
      //this.showLargeModal();
      this.openLg(content)
    }
  
    public onAddRowSelect($event,content){
      //this.showLargeModal();
      this.openLg(content)
    }
  
  
  
    games = [
  
      {
  
        "id":"1",
  
        "firstName": "DOTA 2",
  
        "lastName": "Strategy"
  
      },
  
      {
  
        "id":"2",
  
        "firstName": "AOE 3",
  
        "lastName": "Strategy"
  
      },
  
      {
  
        "id":"3",
  
        "firstName": "GTA 5",
  
        "lastName": "RPG"
  
      },
  
      {
  
        "id":"4",
  
        "firstName": "Far Cry 3",
  
        "lastName": "Action"
  
      },
  
      {
  
        "id":"5",
  
        "firstName": "GTA San Andreas",
  
        "lastName": "RPG"
  
      },
  
      {
  
        "id":"6",
  
        "firstName": "Hitman",
  
        "lastName": "Action"
  
      },
  
      {
  
        "id":"7",
  
        "firstName": "NFS MW",
  
        "lastName": "Sport"
  
      },{
  
        "id":"8",
  
        "firstName": "Fifa 16",
  
        "lastName": "Sport"
  
      },{
  
        "id":"9",
  
        "firstName": "NFS Sen 2",
  
        "lastName": "Sport"
  
      },{
  
        "id":"10",
  
        "firstName": "Witcher Assasins on King",
  
        "lastName": "Adventure"
  
      }
  
    ]
  /********************] data table configurationz [end] *[**********************************/

}
