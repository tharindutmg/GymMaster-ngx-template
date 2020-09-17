import {Injectable} from '@angular/core';
import {HttpClient, HttpRequest, HttpEvent} from '@angular/common/http';
import {Observable} from 'rxjs/Observable';
import { NbToastrService } from '@nebular/theme';

import { ToasterConfig } from 'angular2-toaster';

import 'style-loader!angular2-toaster/toaster.css';
import { NbGlobalLogicalPosition, NbGlobalPhysicalPosition, NbGlobalPosition } from '@nebular/theme';
import { NbToastStatus } from '@nebular/theme/components/toastr/model';

@Injectable()
export class ToastrService {

  constructor(private toastrService: NbToastrService) {}

  config: ToasterConfig;

  index = 1;
  destroyByClick = true;
  duration = 6000;
  hasIcon = true;
  position: NbGlobalPosition = NbGlobalLogicalPosition.TOP_END;
  preventDuplicates = false;
  status: NbToastStatus = NbToastStatus.SUCCESS;

  title = 'HI there!';
  content = `I'm cool toaster!`;

  public showToast(type: NbToastStatus, title: string, body: string) {
    const config = {
      status: type,
      destroyByClick: this.destroyByClick,
      duration: this.duration,
      hasIcon: this.hasIcon,
      position: this.position,
      preventDuplicates: this.preventDuplicates,
    };
    const titleContent = title ? `${title}` : '';

    this.index += 1;
    this.toastrService.show(
      body,
      `${titleContent}`,
      config);
  }

}