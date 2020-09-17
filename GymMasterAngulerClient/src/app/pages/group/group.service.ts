import {Injectable} from '@angular/core';
import {HttpClient, HttpRequest, HttpEvent} from '@angular/common/http';
import {Observable} from 'rxjs/Observable';
import { Group } from './group';
import { URL } from '../common/common-url';
import { CommonResponce } from '../common/common-responce';

@Injectable()
export class GroupService {
  
  

  _url=URL.group;

  constructor(private _http: HttpClient) {}

  createAndUpdateGroup(group:Group,file: File) {
    console.info(file)
    const formdata: FormData = new FormData();
    

    //const req = new HttpRequest('POST', this._url, formdata);
    //return this._http.request(req);
    if(file){
      formdata.append('group', JSON.stringify({group}));
      formdata.append('file', file);
      return this._http.post<Group>(this._url,formdata);
    }else{
      return this._http.post<Group>(this._url+"/noImage",group);
    }
    
  }

  getAllGroups(){
    return this._http.get<Group[]>(this._url);
  }
  getGroupById(groupId:string) {
    return this._http.get<Group>(this._url+"/"+groupId);
  }

  showTemporyImage(image: File) {
    const formdata: FormData = new FormData();
    formdata.append('file', image);
    return this._http.post<Group>(this._url+"/temporyImage",formdata);
  }

  deleteGroup(groupId: any) {
    return this._http.delete<CommonResponce>(this._url+"/"+groupId);
  }

}