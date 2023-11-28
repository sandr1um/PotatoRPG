// main.js

import Vue from 'vue';
import App from './App.vue';
import VueRouter from 'vue-router';
import GameComponent from './components/GameComponent.vue';

Vue.config.productionTip = false;

Vue.use(VueRouter);

const routes = [
    { path: '/', component: GameComponent },
    // Add more routes if needed
];

const router = new VueRouter({
    routes,
});

new Vue({
    render: h => h(App),
    router,
}).$mount('#app');