<template>
    <div>
        <d-section>
            content
        </d-section>
    </div>
</template>

<script lang="ts">
import Vue from 'vue'
import Component from "vue-class-component";
import DSection from "~/components/DSection.vue";
@Component({
    components: {DSection}
})
export default class IndexPage extends Vue {

}
</script>

<style>
html, body {
    @apply p-0 min-w-full min-h-full
}
</style>
