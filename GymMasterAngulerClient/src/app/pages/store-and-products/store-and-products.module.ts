import { NgModule } from '@angular/core';

import { ThemeModule } from '../../@theme/theme.module';
import { ProductsComponent } from './products/products.component';
import { StoreComponent } from './store/store.component';
import { StoreAndProductsComponent } from './store-and-products.component';
import { StoreAndProductsRoutingModule } from './store-and-products-routing.module';

const components = [
    StoreAndProductsComponent,
    ProductsComponent,
    StoreComponent,
];

@NgModule({
  imports: [
    ThemeModule,
    StoreAndProductsRoutingModule,
  ],
  declarations: [
    ...components,
  ],
})
export class StoreAndProductsModule { }