import AOS from 'aos'
import 'aos/dist/aos.css'
import {Component, Vue} from "vue-property-decorator";

@Component
export default class Aos extends Vue {
    mounted() {
        AOS.init({})
    }
}
