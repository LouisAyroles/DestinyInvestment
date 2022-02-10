<template>
    <div class="sections h-full overflow-y-hidden">
        <d-app-bar class="fixed top-0 left-0 right-0"/>
        <d-section class="error-section">
            <div class="main-section-container">
                <div class="main-left-panel">
                    <h1 class="main-title">404</h1>
                    <h1 class="main-subtitle">PAGE NOT FOUND</h1>
                    <div class="flex gap-6">
                        <d-button class="mt-8 text-white" :gradient="false"
                                  icon="home" link-to="/" :is-nuxt-link="true">HOME
                        </d-button>
                        <d-button class="mt-8 text-white" :gradient="false"
                                  icon="account-box" link-to="/#contact" :is-nuxt-link="true">CONTACT
                        </d-button>
                    </div>

                </div>

                <div class="main-right-panel">
                    <img src="@/assets/infography/error.svg" alt="destiny">
                </div>
            </div>
        </d-section>
    </div>


</template>

<script lang="ts">

import {Component, Vue} from 'vue-property-decorator'

@Component
export default class error extends Vue {
}
</script>

<style lang="scss" scoped>
.error-section {
    @apply mt-20 flex flex-col 2xl:bg-[url('@/assets/infography/bg.svg')] md:bg-[url('@/assets/infography/bg-md.svg')];
    background-repeat: no-repeat;
}

.main-section-container {
    @apply relative h-full grow grid grid-rows-2 md:grid-rows-1 md:grid-cols-2 place-items-center md:px-0 overflow-x-hidden;

    .main-left-panel {
        @apply flex flex-col grow items-center md:ml-20 md:mt-20 lg:ml-0 lg:mt-0 lg:h-full justify-center;
        @apply z-30;
    }

    .main-right-panel {
        @apply absolute bottom-0 right-0 max-w-[100%] sm:max-w-[80%] md:max-w-[60%] lg:max-w-[50%] overflow-x-hidden;
    }

    .main-title {
        @apply text-3xl md:text-5xl xl:text-6xl text-center md:text-left text-yellow-400
    }

    .main-subtitle {
        @apply mt-8 text-center text-xs md:text-lg xl:text-2xl sm:text-left dark:text-white
    }
}


</style>
