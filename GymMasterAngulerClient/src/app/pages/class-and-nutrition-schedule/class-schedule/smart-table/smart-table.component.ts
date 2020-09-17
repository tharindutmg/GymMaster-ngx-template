import { Component ,OnInit} from '@angular/core';
import { LocalDataSource } from 'ng2-smart-table';
import { SmartTableData } from '../../../../@core/data/smart-table';


@Component({
  selector: 'smart-table',
  templateUrl: './smart-table.component.html',
  styles: [`
    nb-card {
      transform: translate3d(0, 0, 0);
    }
  `]
})
export class SmartTableComponent {

  settings = {
    // Hide the action button
    actions: {
      add: false,
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

  source: LocalDataSource = new LocalDataSource();
  //private service: SmartTableData
  constructor() {
    //const data = this.service.getData();
    const data = this.games;
    this.source.load(data);
  }

  onDeleteConfirm(event): void {
    if (window.confirm('Are you sure you want to delete?')) {
      event.confirm.resolve();
    } else {
      event.confirm.reject();
    }
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
}
