export default {
    // Target: https://go.nuxtjs.dev/config-target
    target: 'static',

    // Global page headers: https://go.nuxtjs.dev/config-head
    head: {
        title: 'Destiny Connexion',
        htmlAttrs: {
            lang: 'en',
            class: 'light-mode'
        },
        meta: [
            {charset: 'utf-8'},
            {name: 'viewport', content: 'width=device-width, initial-scale=1'},
            {hid: 'description', name: 'description', content: ''},
            {name: 'format-detection', content: 'telephone=no'}
        ],
        link: [
            {rel: 'icon', type: 'image/x-icon', href: '/favicon.ico'},
            {
                rel: "stylesheet",
                href: "https://fonts.googleapis.com/css2?family=Poppins:wght@300&display=swap"

            }
        ]
    },

    // Global CSS: https://go.nuxtjs.dev/config-css
    css: [
        '@/assets/css/main.css',
        '@mdi/font/css/materialdesignicons.min.css'
    ],


    // Plugins to run before rendering page: https://go.nuxtjs.dev/config-plugins
    plugins: [
        {
            src: '~/plugins/observer.ts',
            ssr: true
        },
        {
            src: '~/plugins/swiper.ts',
            ssr: false
        },
        {
            src: '~/plugins/notifier.ts',
            ssr: false
        }
    ],

    // Auto import components: https://go.nuxtjs.dev/config-components
    components: true,

    // Modules for dev and build (recommended): https://go.nuxtjs.dev/config-modules
    buildModules: [
        // https://go.nuxtjs.dev/typescript
        '@nuxt/typescript-build',
        // https://go.nuxtjs.dev/tailwindcss
        '@nuxtjs/tailwindcss',
        '@nuxt/postcss8',
        '@nuxtjs/color-mode'
    ],

    tailwindcss: {
        exposeConfig: true
    },
    colorMode: {
        classSuffix: '-mode'
    },

    // Modules: https://go.nuxtjs.dev/config-modules
    modules: [
        // https://go.nuxtjs.dev/axios
        '@nuxtjs/proxy',
        '@nuxtjs/axios',
    ],

    proxy: {
        '/api': 'http://localhost:8080',
    },
    // Axios module configuration: https://go.nuxtjs.dev/config-axios
    axios: {
        // Workaround to avoid enforcing hard-coded localhost:3000: https://github.com/nuxt-community/axios-module/issues/308
        baseURL: '/'
    },

    // Build Configuration: https://go.nuxtjs.dev/config-build
    build: {
        loaders: {
            sass: {
                implementation: require('sass'),
            },
            scss: {
                implementation: require('sass'),
            },
        },

        postcss: {
            plugins: {
                tailwindcss: {},
                autoprefixer: {}
            },
        },

        transpile: ['mdi-vue']
    }
}
