import { RouterModule, Routes } from '@angular/router';
import { NgModule } from '@angular/core';

import { PagesComponent } from './pages.component';
import { DashboardComponent } from './dashboard/dashboard.component';
import { MembershipTypeComponent } from './membership-type/membership-type.component';
import { GroupComponent } from './group/group.component';
import { ClassScheduleComponent } from './class-and-nutrition-schedule/class-schedule/class-schedule.component';
import { NutritionScheduleComponent } from './class-and-nutrition-schedule/nutrition-schedule/nutrition-schedule.component';
import { ActivityComponent } from './activity/activity.component';
import { EventComponent } from './event/event.component';
import { AttendanceComponent } from './attendance/attendance.component';
import { MessageComponent } from './message/message.component';
import { NewsletterComponent } from './newsletter/newsletter.component';
import { NoticeComponent } from './notice/notice.component';
import { ReportComponent } from './report/report.component';
import { GeneralSettingsComponent } from './general-settings/general-settings.component';
import { AccessRightComponent } from './access-right/access-right.component';

const routes: Routes = [{
  path: '',
  component: PagesComponent,
  children: [
    {
      path: 'dashboard',
      component: DashboardComponent,
    },
    {
      path: 'membershipType',
      component: MembershipTypeComponent,
    },
    {
      path: 'group',
      component: GroupComponent,
    },
    {
      path: 'class-and-nutrition-schedule',
      loadChildren: './class-and-nutrition-schedule/class-and-nutrition-schedule.module#ClassAndNutritionScheduleModel',
    },
    {
      path: 'member-management',
      loadChildren: './member-management/member-management.module#MemberManagementModule',
    },
    {
      path: 'activity',
      component: ActivityComponent,
    },
    {
      path: 'workout',
      loadChildren: './workout/workout.module#WorkoutModule',
    },
    {
      path: 'store-and-products',
      loadChildren: './store-and-products/store-and-products.module#StoreAndProductsModule',
    },
    {
      path: 'event',
      component: EventComponent,
    },
    {
      path: 'attendance',
      component: AttendanceComponent,
    },
    {
      path: 'payment',
      loadChildren: './payment/payment.module#PaymentModule',
    },
    {
      path: 'message',
      component: MessageComponent,
    },
    {
      path: 'newsletter',
      component: NewsletterComponent,
    },
    {
      path: 'notice',
      component: NoticeComponent,
    },
    {
      path: 'report',
      component: ReportComponent,
    },
    {
      path: 'general-settings',
      component: GeneralSettingsComponent,
    },
    {
      path: 'access-right',
      component: AccessRightComponent,
    },
    {
      path: '',
      redirectTo: 'dashboard',
      pathMatch: 'full',
    },
  ],
}];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule],
})
export class PagesRoutingModule {
}
