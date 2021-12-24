<template>
    <span :class="['mdi', 'mdi-' + icon]"></span>
</template>

<script lang="ts">
import { Component, Prop, Vue } from 'vue-property-decorator'

@Component
export default class DIcon extends Vue {
    @Prop({required: true, type: String})
    icon!: string
}
</script>

<style lang="scss" scoped>

</style>
