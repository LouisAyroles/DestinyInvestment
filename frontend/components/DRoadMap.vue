<template>
    <div class="main-container">
        <div class="sub-container">
            <div class="timeline" style="left: 50%"></div>
            <!-- right timeline -->
            <div class="right-container">
                <div class="order-1 w-5/12"></div>
                <div class="dot-white">
                </div>
                <div class="little-right-card">
                    <div class="background">
                        <h3 class="title">February 2, 2022</h3>
                        <p class="desc">Project is raising stars</p>
                    </div>
                </div>
            </div>

            <!-- left timeline -->
            <div class="left-container">
                <div class="order-1 w-5/12"></div>
                <div class="dot-white"></div>
                <div class="little-left-card">
                    <div class="background">
                        <h3 class="title">May 01, 2022</h3>
                        <p class="desc">Projects available</p>
                    </div>
                </div>
            </div>

            <!-- right timeline -->
            <div class="right-container">
                <div class="order-1 w-5/12"></div>
                <div class="dot-primary">
                </div>
                <div class="little-right-card">
                    <div class="background">
                        <h3 class="title">November 01, 2021 </h3>
                        <p class="desc">You will be able to invest</p>
                    </div>
                </div>
            </div>

            <!-- left timeline -->
            <div class="left-container">
                <div class="order-1 w-5/12"></div>
                <div class="dot-primary">
                </div>
                <div class="little-left-card">
                    <div class="background">
                        <h3 class="title">September 03, 2021 </h3>
                        <p class="desc">First event in Barcelona</p>
                    </div>
                </div>
            </div>
        </div>
    </div>

</template>

<script lang="ts">

import {Component, Vue} from 'vue-property-decorator'

@Component
export default class DRoadMap extends Vue {
}
</script>

<style lang="scss" scoped>
    .main-container{
        @apply container bg-black mx-auto w-full h-full
    }
    .sub-container{
        @apply relative overflow-hidden p-10 h-full
    }
    .timeline{
        @apply absolute border-opacity-70 border-white h-full border
    }
    .right-container{
        @apply mb-8 flex justify-between items-center w-full
    }
    .left-container{
        @apply mb-8 flex justify-between flex-row-reverse items-center w-full
    }
    .dot-white{
        @apply z-20 flex items-center order-1 bg-white shadow-xl w-7 h-7 rounded-full
    }
    .dot-primary{
        @apply z-20 flex items-center order-1 bg-primary shadow-xl w-7 h-7 rounded-full
    }
    .little-right-card{
        @apply order-1 grid justify-items-start shadow-xl w-5/12
    }
    .little-left-card{
        @apply order-1 grid justify-items-end shadow-xl w-5/12
    }
    .background{
        @apply bg-gray-900 rounded-lg px-6 py-4
    }
    .title{
        @apply mb-3 font-bold text-white text-xl
    }
    .desc{
        @apply text-sm font-medium leading-snug tracking-wide text-primary text-opacity-100
    }
</style>
