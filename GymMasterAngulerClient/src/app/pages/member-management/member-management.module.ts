import { NgModule } from '@angular/core';

import { ThemeModule } from '../../@theme/theme.module';
import { MemberManagementRoutingModule } from './member-management-routing.module';
import { MemberManagementComponent } from './membar-management.component';
import { MembersComponent } from './members/members.component';
import { StaffMemberComponent } from './staff-member/staff-member.component';
import { AccountentComponent } from './accountent/accountent.component';
import { Ng2SmartTableModule } from 'ng2-smart-table';

const components = [
    MemberManagementComponent,
    MembersComponent,
    StaffMemberComponent,
    AccountentComponent,
];

@NgModule({
  imports: [
    ThemeModule,
    MemberManagementRoutingModule,
    Ng2SmartTableModule,
  ],
  declarations: [
    ...components,
  ],
})
export class MemberManagementModule { }