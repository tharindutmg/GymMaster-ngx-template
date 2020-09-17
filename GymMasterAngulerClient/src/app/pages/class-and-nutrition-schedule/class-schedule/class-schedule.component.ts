import { Component, OnInit } from '@angular/core';
import { NgbModal,NgbTimepicker } from '@ng-bootstrap/ng-bootstrap';
import { LocalDataSource } from 'ng2-smart-table';
import { ClassSchedule } from './class-schedule';

@Component({
  selector: 'class-schedule',
  templateUrl: './class-schedule.component.html',
  styleUrls: ['./class-schedule.component.scss']
})
export class ClassScheduleComponent implements OnInit {
  modalHeader: string="Class Schedule";
  formName:string="Create Class Schedule";
  mainPageName:string = "Class Schedule" 

  source: LocalDataSource = new LocalDataSource();

  classScheduleMainModel = new ClassSchedule();
  
  constructor(private modalService: NgbModal) {
    const data = this.games;
    this.source.load(data);

    /* this.selectTableOptions.push("Customers");
    this.selectTableOptions.push("Employees");  */
   }

   dropdownList = [];
   //selectedItems = [];
   dropdownSettings = {};
  ngOnInit() {
    //this.classScheduleMainModel.endTime={hour: 13, minute: 30};
    this.dropdownList = [
      { item_id: 1, item_text: 'Sunday' },
      { item_id: 2, item_text: 'Monday' },
      { item_id: 3, item_text: 'Tuesday' },
      { item_id: 4, item_text: 'Tursday' },
      { item_id: 5, item_text: 'Friday' }
    ];
    /* this.selectedItems = [
      { item_id: 3, item_text: 'Pune' },
      { item_id: 4, item_text: 'Navsari' }
    ]; */
    this.dropdownSettings = {
      singleSelection: false,
      idField: 'item_id',
      textField: 'item_text',
      selectAllText: 'Select All',
      unSelectAllText: 'UnSelect All',
      itemsShowLimit: 3,
      allowSearchFilter: true
    };


  }

 // time = {hour: 13, minute: 30};
  onItemSelect(item: any) {
    console.log(item);
  }
  onSelectAll(items: any) {
    console.log(items);
  }

  public submit(){
    console.info(this.classScheduleMainModel);
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

  openmd(modal2){
    this.activeModal=this.modalService.open(modal2);
  }
  
/******************************** model common function [end]********************************/
/********************] data table configurationz [start] *[**********************************/


  public onDeleteRowSelect($event){

  }
  public onEditRowSelect($event,content){
    this.openLg(content);
  }
  public onAddRowSelect($event,content){
    this.openLg(content);
  }

  settings = {
    mode: 'external',
    actions: {
      position: 'right', // left|right
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

