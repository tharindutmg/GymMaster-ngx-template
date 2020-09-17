import { NgModule } from '@angular/core';

import { ThemeModule } from '../../@theme/theme.module';
import { MembershipPaymentComponent } from './membership-payment/membership-payment.component';
import { IncomeComponent } from './income/income.component';
import { ExpensesComponent } from './expenses/expenses.component';
import { PaymentComponent } from './payment.component';
import { PaymentRoutingModule } from './payment-routing.module';

const components = [
    PaymentComponent,
    MembershipPaymentComponent,
    IncomeComponent,
    ExpensesComponent,
];

@NgModule({
  imports: [
    ThemeModule,
    PaymentRoutingModule,
  ],
  declarations: [
    ...components,
  ],
})
export class PaymentModule { }