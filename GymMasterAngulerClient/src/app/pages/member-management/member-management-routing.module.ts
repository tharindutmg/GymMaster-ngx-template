import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { MemberManagementComponent } from './membar-management.component';
import { MembersComponent } from './members/members.component';
import { StaffMemberComponent } from './staff-member/staff-member.component';
import { AccountentComponent } from './accountent/accountent.component';

const routes: Routes = [{
  path: '',
    component: MemberManagementComponent,
  children: [ {
    path: 'members',
    component: MembersComponent,
  }, {
    path: 'staff-member',
    component: StaffMemberComponent,
  },{
    path: 'accountent',
    component: AccountentComponent,
  }],
}];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule],
})
export class MemberManagementRoutingModule { }
