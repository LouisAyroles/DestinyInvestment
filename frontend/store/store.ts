import VueX from 'vuex';


// See https://github.com/michaelolof/vuex-class-component#new-api for documentation

export const store = new VueX.Store({
    modules: {
        //...extractVuexModule(YourModule)
    }
})

const vxm = {
    // name: createProxy(store, YourModule)
}
