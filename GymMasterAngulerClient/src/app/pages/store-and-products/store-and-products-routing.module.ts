import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { StoreAndProductsComponent } from './store-and-products.component';
import { StoreComponent } from './store/store.component';
import { ProductsComponent } from './products/products.component';

const routes: Routes = [{
  path: '',
    component: StoreAndProductsComponent,
  children: [ {
    path: 'products',
    component: ProductsComponent,
  }, {
    path: 'store',
    component: StoreComponent,
  }],
}];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule],
})
export class StoreAndProductsRoutingModule { }
