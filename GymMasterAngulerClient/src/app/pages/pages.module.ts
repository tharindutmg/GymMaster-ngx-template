import { NgModule } from '@angular/core';

import { PagesComponent } from './pages.component';
import { DashboardModule } from './dashboard/dashboard.module';
import { PagesRoutingModule } from './pages-routing.module';
import { ThemeModule } from '../@theme/theme.module';
import { MiscellaneousModule } from './miscellaneous/miscellaneous.module';
import { MembershipTypeModule } from './membership-type/membership-type.module';
import { GroupModule } from './group/group.module';
import { ClassAndNutritionScheduleModel } from './class-and-nutrition-schedule/class-and-nutrition-schedule.module';
import { MemberManagementModule } from './member-management/member-management.module';
import { ActivityModule } from './activity/activity.module';
import { AssignWorkoutComponent } from './workout/assign-workout/assign-workout.component';
import { DallyWorkoutComponent } from './workout/dally-workout/dally-workout.component';
import { WorkoutModule } from './workout/workout.module';
import { StoreAndProductsModule } from './store-and-products/store-and-products.module';
import { EventModule } from './event/event.module';
import { AttendanceModule } from './attendance/attendance.module';
import { PaymentModule } from './payment/payment.module';
import { MessageModule } from './message/message.module';
import { NewsletterModule } from './newsletter/newsletter.module';
import { NoticeModule } from './notice/notice.module';
import { ReportModule } from './report/report.module';
import { GeneralSettingsModule } from './general-settings/general-settings.module';
import { AccessRightModule } from './access-right/access-right.module';

const PAGES_COMPONENTS = [
  PagesComponent,
];

@NgModule({
  imports: [
    PagesRoutingModule,
    ThemeModule,
    DashboardModule,
    MiscellaneousModule,
    MembershipTypeModule,
    GroupModule,
    ClassAndNutritionScheduleModel,
    MemberManagementModule,
    ActivityModule,
    WorkoutModule,
    StoreAndProductsModule,
    EventModule,
    AttendanceModule,
    PaymentModule,
    MessageModule,
    NewsletterModule,
    NoticeModule,
    ReportModule,
    GeneralSettingsModule,
    AccessRightModule,
  ],
  declarations: [
    ...PAGES_COMPONENTS,
  ],
})
export class PagesModule {
}
