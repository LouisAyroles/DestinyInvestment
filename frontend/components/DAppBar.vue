<template>
    <nav ref="menu" class="backdrop-blur-sm z-50 animated">
        <div class="margin">
            <div class="content">
                <div class="center">
                    <!-- Mobile menu button-->
                    <button type="button" ref="mobile-toggle" class="center mobile-menu-button" aria-controls="mobile-menu" aria-expanded="false">
                        <span class="sr-only">Open main menu</span>
                        <!--Icon when menu is closed. -->
                        <svg class="block h-6 w-6" xmlns="http://www.w3.org/2000/svg" fill="none" viewBox="0 0 24 24" stroke="currentColor" aria-hidden="true">
                            <path stroke-linecap="round" stroke-linejoin="round" stroke-width="2" d="M4 6h16M4 12h16M4 18h16" />
                        </svg>
                        <!--Icon when menu is open.-->
                        <svg class="hidden h-6 w-6" xmlns="http://www.w3.org/2000/svg" fill="none" viewBox="0 0 24 24" stroke="currentColor" aria-hidden="true">
                            <path stroke-linecap="round" stroke-linejoin="round" stroke-width="2" d="M6 18L18 6M6 6l12 12" />
                        </svg>
                    </button>
                </div>
                <div class="items">
                    <div class="logos">
                        <img class="logo" src="@/assets/logos/destinylogo.png" alt="Destiny">
                        <img class="full-logo" src="@/assets/logos/destinyfullLogo.png" alt="Destiny">
                    </div>
                    <div class="menu-items">
                        <div class="flex space-x-4">
                            <nuxt-link
                                v-for="(item, index) in menuItems"
                                :key="index"
                                :to="item.href"
                                class="title">
                                {{ item.title }}
                            </nuxt-link>
                        </div>
                    </div>
                </div>
            </div>
        </div>

        <!-- Mobile menu, show/hide based on menu state. -->
        <div ref="mobile-menu" class="hidden sm:hidden mobile-menu">
            <div class="px-2 pt-2 pb-3 space-y-1">
                <nuxt-link
                    v-for="(item, index) in menuItems"
                    :key="index"
                    :to="item.href"
                    class="mobile-title">
                    {{ item.title }}
                </nuxt-link>
            </div>
        </div>
    </nav>
</template>

<script lang="ts">

import {Component, Vue} from 'vue-property-decorator'

@Component
export default class DAppBar extends Vue {
    readonly menuItems = [
        { title: 'Home',    href: '#home' },
        { title: 'Raise',   href: '#raise' },
        { title: 'Invest',  href: '#invest' },
        { title: 'Blog',    href: '#blog' },
        { title: 'Contact', href: '#contact' },
    ]
    mounted() {
        const button = this.$refs['mobile-toggle'] as HTMLElement
        button.addEventListener('click', this.toggleMobileMenu)
        window.addEventListener('scroll', this.scrollListener)
    }

    beforeDestroy() {
        const button = this.$refs['mobile-toggle'] as HTMLElement
        button.removeEventListener('click', this.toggleMobileMenu)
        window.removeEventListener('scroll', this.scrollListener)
    }

    toggleMobileMenu() {
        const menu = this.$refs['mobile-menu'] as HTMLElement
        menu.classList.toggle('hidden')
    }

    scrollListener() {
        function getBackgroundColor(el: HTMLElement): string | undefined {
            return document.defaultView?.getComputedStyle(el,null).backgroundColor;
        }

        const menu = this.$refs['menu'] as HTMLElement
        const elements = document.elementsFromPoint(0, menu.getBoundingClientRect().bottom)
        const section = elements.find(el => el.tagName.toLowerCase() == 'section') as (HTMLElement | undefined)
        if (!section) return

        const bgColor = getBackgroundColor(section)
        if (!bgColor) return
        menu.style.backgroundColor = bgColor

        console.log(section.id)
        //this.$router.replace('/')
    }
}
</script>

<style lang="scss" scoped>
.margin{
    @apply max-w-7xl mx-auto px-2 sm:px-6 lg:px-8;
}

.content{
    @apply relative flex items-center justify-between h-20;
}

.mobile{
    @apply inline-flex items-center justify-center p-2 rounded-md text-gray-400;
    @apply focus:outline-none focus:ring-2 focus:ring-inset focus:ring-white;
    @apply hover:text-white hover:bg-gray-700;
}

.center{
    @apply absolute inset-y-0 left-0 flex items-center sm:hidden
}

.items {
    @apply flex-1 flex items-center justify-center sm:items-stretch sm:justify-start sm:justify-between
}

.title{
    @apply text-gray-300 hover:bg-gray-700 hover:text-white px-3 py-2 rounded-md text-lg font-medium
}

.titleHome{
    @apply text-gray-300 hover:bg-gray-700 hover:text-white px-3 py-2 dark:text-primary rounded-md text-lg font-medium
}

.mobile-title{
    @apply text-gray-300 hover:bg-gray-700 hover:text-white block px-3 py-2 rounded-md text-base font-medium
}

.menu-items{
    @apply hidden items-center justify-end sm:block sm:ml-6
}

.logos{
    @apply flex-shrink-0 flex items-center
}

.logo{
    @apply block lg:hidden h-8 w-auto
}

.full-logo{
    @apply hidden lg:block h-16 w-auto
}

.animated {
    transition: all 0.250s;
}
</style>
