module.exports = {
    content: [
        "./components/**/*.{js,vue,ts}",
        "./layouts/**/*.vue",
        "./pages/**/*.vue",
        "./plugins/**/*.{js,ts}",
        "./nuxt.config.{js,ts}"
    ],
    theme: {
        extend: {
            colors: {
                'primary': '#8E97DF',
                'secondary': '#DF8EC8'
            }
        },
    },
    plugins: [],
}
