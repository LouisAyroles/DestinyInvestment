<template>
    <div class="pt-20 sections h-full">
        <d-app-bar currentPage="Invest" class="fixed top-0 left-0 right-0"/>
        <d-section class="flex flex-col">
            <div class="p-0 md:py-12 md:px-20 lg:px-32">
                <d-stepper :steps="steps" :currentStep=currentStep></d-stepper>
            </div>
            <div class="flex container-form grow items-center min-w-full">
                <div class="flex justify-center">
                    <div class="first-subcard"></div>
                    <div class="second-subcard"></div>
                </div>

                <swiper @slide-change="scrollToTheTop" ref="mySwiper" :options="swiperOptions">
                    <swiper-slide ref="first-card">
                        <div class="flex justify-center">
                            <div class="card-container self-center flex flex-col min-w-full md:min-w-0">
                                <div class="hidden md:block">
                                    <h1 class="title">Personal details</h1>
                                </div>

                                <div class="input-container">
                                    <div class="inputs">
                                        <div class="relative">
                                            <div class="relative">
                                                <input autocomplete="off" v-model="name" name="name" type="text"
                                                       :class="{'border-primary-dark' :!isNameValid && this.tryToNext}"
                                                       class="peer placeholder-transparent px-2 h-10 w-full border-2 rounded-lg text-gray-900 focus:outline-none focus:borer-rose-600"
                                                       placeholder="Email address"/>
                                                <label for="email"
                                                       class="absolute ml-2 left-0 -top-3.5 text-gray-600 text-sm peer-placeholder-shown:text-base peer-placeholder-shown:text-gray-440 peer-placeholder-shown:top-2 transition-all peer-focus:-top-5 peer-focus:text-gray-600 peer-focus:text-sm">Name</label>
                                                <span class="text-sm text-primary"
                                                      v-if="!isNameValid && this.tryToNext">Please fill your name </span>
                                                <span class="text-sm"
                                                      v-if="!(!isNameValid && this.tryToNext)">&nbsp</span>
                                            </div>
                                        </div>
                                        <div class="relative">
                                            <input autocomplete="off" v-model="mail" name="email" type="text"
                                                   :class="{'border-primary-dark' :!isMailValid && this.tryToNext}"
                                                   class="peer placeholder-transparent px-2 h-10 w-full border-2 rounded-lg text-gray-900 focus:outline-none focus:borer-rose-600"
                                                   placeholder="Email address"/>
                                            <label for="email"
                                                   class="absolute ml-2 left-0 -top-3.5 text-gray-600 text-sm peer-placeholder-shown:text-base peer-placeholder-shown:text-gray-440 peer-placeholder-shown:top-2 transition-all peer-focus:-top-5 peer-focus:text-gray-600 peer-focus:text-sm">Email
                                                Address</label>
                                            <span class="text-sm text-primary" v-if="!isMailValid && this.tryToNext">Please fill your email </span>
                                            <span class="text-sm" v-if="!(!isMailValid && this.tryToNext)">&nbsp</span>
                                        </div>
                                    </div>
                                </div>
                                <div class="flex justify-end items-center gap-3">
                                    <d-button @click.native="next" icon="arrow-right-thick" class="text-white"/>
                                </div>
                            </div>
                        </div>
                    </swiper-slide>

                    <!-- Second Card -->
                    <swiper-slide ref="second-card">
                        <div class="flex justify-center">
                            <div class="card-container-checkbox self-center flex flex-col min-w-full md:min-w-0">
                                <div class="hidden md:block">
                                    <h1 class="title">Investment field</h1>
                                </div>
                                <span class="text-slate-500 text-center md:text-left"> What are your areas of Investment?</span>
                                <span class="error text-center md:text-left" v-if="!isValidCard2 && this.tryToNext">Please choose one item at list </span>
                                <span class="error" v-if="!(!isValidCard2 && this.tryToNext)">&nbsp</span>
                                <div class="input-container grow">
                                    <div class="checkboxs">
                                        <div class="flex flex-col items-center justify-center">
                                            <div class="grid grid-cols-1 md:grid-cols-3">
                                                <div v-for="invest in investmentFields" :key="invest">
                                                    <label class="inline-flex items-center mt-3">
                                                        <input :value="invest" type="checkbox"
                                                               v-model="checkedInvestments"
                                                               class="form-checkbox h-5 w-5 text-gray-600"><span
                                                        class="ml-2 text-gray-700">{{ invest }}</span>
                                                    </label>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>

                                <div class="flex justify-end items-center gap-3">
                                    <d-button @click.native="prev" icon="arrow-left-thick" class="text-white"/>
                                    <d-button @click.native="next" icon="arrow-right-thick" class="text-white"/>
                                </div>
                            </div>
                        </div>
                    </swiper-slide>

                    <!-- Third Card -->
                    <swiper-slide ref="third-card">
                        <div class="flex justify-center">
                            <div class="card-container-checkbox self-center flex flex-col min-w-full md:min-w-0">
                                <div class="hidden md:block">
                                    <h1 class="title">Investment field</h1>
                                </div>
                                <span class="text-slate-500 text-center md:text-left">Which company stage is more interesting for you?</span>
                                <span class=" error text-center md:text-left" v-if="!isValidCard3 && this.tryToNext">Please let us know what your preference is. </span>
                                <span class="error" v-if="!(!isValidCard3 && this.tryToNext)">&nbsp</span>
                                <div class="mt-10 grow">
                                    <label class="inline-flex items-center mt-3">
                                        <input type="radio" value="EarlierWithHigherReturn"
                                               v-model="investmentChoice"
                                               class="form-checkbox h-5 w-5 text-gray-600"><span
                                        class="ml-2 text-gray-700">Earlier stage with higher return potential</span>
                                    </label>
                                    <label class="inline-flex items-center mt-3">
                                        <input type="radio" value="LaterWithMarketTraction"
                                               v-model="investmentChoice"
                                               class="form-checkbox h-5 w-5 text-gray-600"><span
                                        class="ml-2 text-gray-700">Later stage growth companies with market traction</span>
                                    </label>
                                </div>

                                <div class="flex justify-end items-center gap-3">
                                    <d-button @click.native="prev" icon="arrow-left-thick" class="text-white"/>
                                    <d-button @click.native="next" icon="arrow-right-thick" class="text-white"/>
                                </div>
                            </div>
                        </div>
                    </swiper-slide>

                    <!-- Fourth Card -->
                    <swiper-slide ref="fourth-card">
                        <div class="flex justify-center">
                            <div class="card-container-checkbox self-center flex flex-col min-w-full md:min-w-0">
                                <div class="hidden md:block">
                                    <h1 class="title">Portfolio size</h1>
                                </div>
                                <span class="text-slate-500 text-center md:text-left">What is your investment portfolio size?</span>
                                <span class="error text-center md:text-left" v-if="!isValidCard4 && this.tryToNext">Please let us know what your portfolio size is. </span>
                                <span class="error" v-if="!(!isValidCard4 && this.tryToNext)">&nbsp</span>
                                <div class="mt-10 grow flex flex-col">
                                    <label class="inline-flex items-center mt-3">
                                        <input type="radio" value="GradeA" v-model="portfolioSize"
                                               class="form-checkbox h-5 w-5 text-gray-600"><span
                                        class="ml-2 text-gray-700"> Less than 500 000€</span>
                                    </label>
                                    <label class="inline-flex items-center mt-3">
                                        <input type="radio" value="GradeB" v-model="portfolioSize"
                                               class="form-checkbox h-5 w-5 text-gray-600"><span
                                        class="ml-2 text-gray-700">500 000€ to 1 000 000€</span>
                                    </label>
                                    <label class="inline-flex items-center mt-3">
                                        <input type="radio" value="GradeC" v-model="portfolioSize"
                                               class="form-checkbox h-5 w-5 text-gray-600"><span
                                        class="ml-2 text-gray-700">1 000 000 to 5 000 000€</span>
                                    </label>
                                    <label class="inline-flex items-center mt-3">
                                        <input type="radio" value="GradeD" v-model="portfolioSize"
                                               class="form-checkbox h-5 w-5 text-gray-600"><span
                                        class="ml-2 text-gray-700">more than 5M</span>
                                    </label>
                                </div>
                                <div class="flex justify-end items-center gap-3">
                                    <d-button @click.native="prev" icon="arrow-left-thick" class="text-white"/>
                                    <d-button @click.native="next" icon="arrow-right-thick" class="text-white"/>
                                </div>
                            </div>
                        </div>
                    </swiper-slide>

                    <!-- Fifth Card -->
                    <swiper-slide ref="fifth-card">
                        <div class="flex justify-center">
                            <div class="confirmation-card-container self-center flex flex-col min-w-full md:min-w-0">
                                <div class="max-w-md mx-auto">
                                    <div class="hidden md:block">
                                        <h1 class="title"> Confirmation </h1>
                                    </div>
                                    <div class="input-container grow">
                                        <div class="inputs">
                                            <div class="relative">
                                                <div class="flex flex-col">
                                                    <div class="flex flex-row my-2 md:my-0">
                                                        <span class="text-primary-dark md:text-gray-700"><b> Name : </b><span
                                                            class="text-black">&nbsp {{ name }}</span></span>

                                                    </div>
                                                    <div class="flex flex-row my-2 md:my-0">
                                                        <span class="text-primary-dark md:text-gray-700"> <b>Email :</b> <span
                                                            class="text-black">&nbsp {{ mail }}</span> </span>

                                                    </div>
                                                    <div class="flex flex-row my-2 md:my-0">
                                                            <span class="text-primary-dark md:text-gray-700"> <b>Investment Fields :</b> <span
                                                                class="text-black"
                                                                v-for="checked in checkedInvestments"> {{
                                                                    checked
                                                                }} </span> </span>

                                                    </div>
                                                    <div class="flex flex-row my-2 md:my-0">
                                                            <span class="text-primary-dark md:text-gray-700"> <b>Interested in </b> <span
                                                                class="text-black">{{
                                                                    mapGrade.get(investmentChoice)
                                                                }}</span> </span>
                                                    </div>
                                                    <div class="flex flex-row my-2 md:my-0">
                                                        <span class="text-primary-dark md:text-gray-700"> <b>Portfolio size :</b> <span
                                                            class="text-black">&nbsp {{
                                                                gradeToPortfolioSize.get(portfolioSize)
                                                            }}</span></span>

                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="flex justify-end items-center gap-3">
                                        <d-button @click.native="prev" icon="arrow-left-thick" class="text-white"/>
                                        <d-button @click.native="submit" icon="check" class="text-white"/>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </swiper-slide>
                </swiper>
            </div>
        </d-section>
    </div>
</template>

<script lang="ts">

import {Component, Vue} from 'vue-property-decorator'
import {Step} from "~/components/DStepper.vue";

@Component
export default class invest extends Vue {

    readonly steps: Step[] = [{
        title: "Personal details",
        icon: "account"
    }, {
        title: "Investment field (1/2)",
        icon: "card-account-details"
    }, {
        title: "Investment field (2/2)",
        icon: "card-account-details"
    }, {
        title: "Portfolio size",
        icon: "briefcase-variant"
    }, {
        title: "Confirmation",
        icon: "check"
    }]

    readonly gradeToPortfolioSize = new Map<string, string>([
        ["GradeA", "Less than 500 000€"],
        ["GradeB", "500 000€ to 1 000 000€"],
        ["GradeC", "1 000 000 to 5 000 000€"],
        ["GradeD", "more than 5M"]
    ]);

    readonly mapGrade = new Map<string, string>([
        ["EarlierWithHigherReturn", "earlier stage with higher return potential"],
        ["LaterWithMarketTraction", "later stage growth companies with market traction"]
    ]);

    readonly investmentFields: string[] = [
        "Sportech", "Greentech", "Fintech", "Blockchain", "Biotech", "E-commerce", "Edtech", "Cybersécurité", "Others", "Artificial Intelligence"
    ]

    readonly swiperOptions = {
        allowTouchMove: false,
        slidesPerView: 1,
        spaceBetween: 10,
        centeredSlides: true,
        centerInsufficientSlides: true,
        autoHeight: true,
        breakpoints: {
            768:
                {
                    autoHeight: false
                }
        }

    }

    currentStep = 0

    //Form value
    name: string = "";
    mail: string = "";
    checkedInvestments = [];
    investmentChoice = ""
    portfolioSize = ""
    tryToNext = false

    get isNameValid() {
        return !!this.name && this.name.length > 0
    }

    get isMailValid() {
        return !!this.mail && this.mail.length > 0
    }

    get isValidCard1() {
        return this.isNameValid && this.isMailValid
    }

    get isValidCard2() {
        return !!this.checkedInvestments && this.checkedInvestments.length > 0
    }

    get isValidCard3() {
        return !!this.investmentChoice && this.investmentChoice.length > 0
    }

    get isValidCard4() {
        return !!this.portfolioSize && this.portfolioSize.length > 0
    }

    get isFormValid() {
        return [this.isValidCard1, this.isValidCard2, this.isValidCard3, this.isValidCard4]
    }


    get swiper() {
        return (this as any).$refs.mySwiper.$swiper
    }

    next() {
        if (!this.isFormValid[this.currentStep]) {
            this.tryToNext = true
            return
        }
        this.tryToNext = false
        this.swiper.slideTo(++this.currentStep, 1000, false)
    }

    prev() {
        this.swiper.slideTo(--this.currentStep, 1000, false)
    }

    scrollToTheTop() {
        window.scrollTo({top: 0, behavior: 'smooth'})
    }

    submit() {
        fetch('api/invest/apply', {
            method: 'POST',
            headers: {
                'Accept': 'application/json, text/plain, */*',
                'Content-Type': 'application/json'
            },
            body: JSON.stringify({
                email: this.mail,
                name: this.name,
                investmentAreas: this.checkedInvestments,
                companyStage: this.investmentChoice,
                portfolioSize: this.portfolioSize,
            })
        }).then(res => {
            this.$router.push({
                path: '/'
            })
            Vue.swal({
                icon: 'success',
                title: 'Perfect',
                text: 'Thank you for your interest !',
            })
        })
            .catch(err => Vue.swal({
                icon: 'error',
                title: 'Oops...',
                text: err.error,
            }));
    }


}
</script>

<style lang="scss" scoped>

@mixin card {
    @apply min-h-[20rem] w-[12rem] md:h-[24rem] md:w-[40rem] sm:rounded-3xl bg-transparent md:bg-slate-100;
}

.second-subcard {
    @include card;
    @apply hidden md:block absolute inset-0 bg-gradient-to-r from-primary-dark to-primary shadow-2xl transform mx-auto sm:rounded-3xl;
    top: 50%;
    transform: translateY(-50%) rotate(-6deg);
}

.first-subcard {
    @include card;
    @apply hidden md:block absolute inset-0 bg-gradient-to-r from-primary to-primary-dark shadow-2xl transform mx-auto sm:rounded-3xl;
    top: 50%;
    transform: translateY(-50%) rotate(-12deg);
}

.slider {
    margin-top: 10em;
    @apply min-h-full
}

.container-form {
    @apply relative py-3 sm:max-w-xl sm:mx-auto;
}

.card-container {
    @include card;
    @apply relative px-4 py-10 justify-between  sm:p-20  md:shadow-lg;
}

.confirmation-card-container {
    @include card;
    @apply relative md:shadow-lg p-4;
}

.card-container-checkbox {
    @include card;
    @apply relative px-4 py-10 ;
}

.title {
    @apply text-2xl font-semibold text-black
}


.inputs {
    @apply py-8 text-base leading-6 space-y-4 text-gray-700 sm:text-lg sm:leading-7;
}

.checkboxs {
    @apply text-base leading-6 space-y-4 text-gray-700 sm:text-lg sm:leading-7;
}

.error {
    @apply text-sm text-primary-dark
}
</style>
