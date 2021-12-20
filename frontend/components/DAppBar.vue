<template>
    <!-- This example requires Tailwind CSS v2.0+ -->
    <nav class="bg-gray-800">
        <div class="margin">
            <div class="content">
                <div class="center">
                    <!-- Mobile menu button-->
                    <button type="button" class="center" aria-controls="mobile-menu" aria-expanded="false">
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
                    <div class=" flex items-center">
                        <img class="block lg:hidden h-8 w-auto image-test" src="@/assets/logos/destinylogo.png" alt="Destiny">
                        <img class="hidden lg:block h-8 w-auto" src="@/assets/logos/destinyfullLogo.png" alt="Destiny">
                    </div>
                    <div class="hidden items-center justify-end sm:block sm:ml-6">
                        <div class="flex space-x-4">
                            <a href="#" class="title" aria-current="page">Home</a>
                            <a href="#" class="title" aria-current="page">Raise</a>
                            <a href="#" class="title">Invest</a>
                            <a href="#" class="title">Blog</a>
                            <a href="#" class="title">Contact us</a>
                        </div>
                    </div>
                </div>
            </div>
        </div>

        <!-- Mobile menu, show/hide based on menu state. -->
        <div class="sm:hidden" id="mobile-menu">
            <div class="px-2 pt-2 pb-3 space-y-1">
                <a href="#" class="title" aria-current="page">Home</a>
                <a href="#" class="title" aria-current="page">Raise</a>
                <a href="#" class="title">Invest</a>
                <a href="#" class="title">Blog</a>
                <a href="#" class="title">Contact us</a>
            </div>
        </div>
    </nav>
</template>

<script lang="ts">

import {Component, Vue} from 'vue-property-decorator'

@Component
export default class DAppBar extends Vue {
}
</script>

<style lang="scss" scoped>
.margin{
    @apply max-w-7xl mx-auto px-2 sm:px-6 lg:px-8;
}

.content{
    @apply relative flex items-center justify-between h-16;
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
    @apply flex-1 flex justify-between items-center sm:items-stretch
}
.title{
    @apply text-gray-300 hover:bg-gray-700 hover:text-white px-3 py-2 rounded-md text-sm font-medium
}
.mobile-title{
    @apply text-gray-300 hover:bg-gray-700 hover:text-white block px-3 py-2 rounded-md text-base font-medium
}
</style>
