import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { PaymentComponent } from './payment.component';
import { IncomeComponent } from './income/income.component';
import { ExpensesComponent } from './expenses/expenses.component';
import { MembershipPaymentComponent } from './membership-payment/membership-payment.component';

const routes: Routes = [{
  path: '',
    component: PaymentComponent,
  children: [ {
    path: 'membership-payment',
    component: MembershipPaymentComponent,
  }, {
    path: 'income',
    component: IncomeComponent,
  },{
    path: 'expenses',
    component: ExpensesComponent,
  }],
}];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule],
})
export class PaymentRoutingModule { }
