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
            },
            lineClamp: {
                7: '7',
                8: '8',
                9: '9',
                10: '10',
                11: '11',
                12: '12',
            }
        },
    },
    variants: {
        backgroundColor: [
            "dark",
            "dark-hover",
            "dark-group-hover",
            "dark-even",
            "dark-odd"
        ],
        borderColor: ["dark", "dark-focus", "dark-focus-within"],
        textColor: ["dark", "dark-hover", "dark-active"]
    },
    plugins: [
        require('@tailwindcss/line-clamp')
    ]
}
