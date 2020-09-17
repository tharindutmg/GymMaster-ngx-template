import { NbMenuItem } from '@nebular/theme';

export const MENU_ITEMS: NbMenuItem[] = [
  {
    title: 'Dashboard',
    icon: 'nb-home',
    link: '/pages/dashboard',
    home: true,
  },
  {
    title: 'Membership Type',
    icon: 'nb-compose',
    link: '/pages/membershipType',
    home: false,
  },
  {
    title: 'Group',
    icon: 'nb-grid-a-outline',
    link: '/pages/group',
    home: false,
  },
  {
    title: 'Class & Nutrition Schedule',
    icon: 'nb-layout-two-column',
    children: [
      {
        title: 'Class Schedule',
        link: '/pages/class-and-nutrition-schedule/class-schedule',
      },
      {
        title: 'Nutrition Schedule',
        link: '/pages/class-and-nutrition-schedule/nutrition-schedule',
      },
    ],
  },
  {
    title: 'Member Management',
    icon: 'nb-person',
    children: [
      {
        title: 'Members',
        link: '/pages/member-management/members',
      },
      {
        title: 'Staff Members',
        link: '/pages/member-management/staff-member',
      },
      {
        title: 'Accountent',
        link: '/pages/member-management/accountent',
      },
    ],
  },
  {
    title: 'Activity',
    icon: 'nb-list',
    link: '/pages/activity',
    home: false,
  },
  {
    title: 'Workout',
    icon: 'nb-compose',
    children: [
      {
        title: 'Assign Workout',
        link: '/pages/workout/assign-workout',
      },
      {
        title: 'Daly Workout',
        link: '/pages/workout/dally-workout',
      },
    ],
  },
  {
    title: 'Store And Products',
    icon: 'nb-layout-default',
    children: [
      {
        title: 'Products',
        link: '/pages/store-and-products/products',
      },
      {
        title: 'Store',
        link: '/pages/store-and-products/store',
      },
    ],
  },
  {
    title: 'Event',
    icon: 'nb-flame-circled',
    link: '/pages/event',
    home: false,
  },
  {
    title: 'Attendance',
    icon: 'nb-edit',
    link: '/pages/attendance',
    home: false,
  },
  {
    title: 'Payment',
    icon: 'nb-layout-default',
    children: [
      {
        title: 'Membership Payment',
        link: '/pages/payment/membership-payment',
      },
      {
        title: 'Income',
        link: '/pages/payment/income',
      },
      {
        title: 'Expenses',
        link: '/pages/payment/expenses',
      },
    ],
  },
  {
    title: 'Message',
    icon: 'nb-email',
    link: '/pages/message',
    home: false,
  },
  {
    title: 'Newsletter',
    icon: 'nb-roller-shades',
    link: '/pages/newsletter',
    home: false,
  },
  {
    title: 'Notice',
    icon: 'nb-compose',
    link: '/pages/notice',
    home: false,
  },
  {
    title: 'Report',
    icon: 'nb-bar-chart',
    link: '/pages/report',
    home: false,
  },
  {
    title: 'General Settings',
    icon: 'nb-gear',
    link: '/pages/general-settings',
    home: false,
  },
  {
    title: 'Access Right',
    icon: 'nb-checkmark',
    link: '/pages/access-right',
    home: false,
  },



  {
    title: 'FEATURES',
    group: true,
  },
  {
    title: 'Auth',
    icon: 'nb-locked',
    children: [
      {
        title: 'Login',
        link: '/auth/login',
      },
      {
        title: 'Register',
        link: '/auth/register',
      },
      {
        title: 'Request Password',
        link: '/auth/request-password',
      },
      {
        title: 'Reset Password',
        link: '/auth/reset-password',
      },
    ],
  },
];
