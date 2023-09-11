<script setup>
import { ref } from 'vue';
import { onUpdated } from 'vue'

    const calculatorValue = ref('');
    const calculatorElements = ref([7,8,9,'+',4,5,6,'-',1,2,3,'*',0,'.','=','/','C']);
    const operator = ref(null);
    const previousCalculatorValue = ref('');

    const action = (n) => {
      if(!isNaN(n) || n === '.'){
        calculatorValue.value += n + '';
      }
      if(n === 'C'){
        calculatorValue.value = '';
      }
      if(['/','*','-','+'].includes(n)){
        operator.value = n;
        previousCalculatorValue.value = calculatorValue.value;
        calculatorValue.value = '';
      }
      if(n === '='){
        calculatorValue.value = eval(
          previousCalculatorValue.value + operator.value + calculatorValue.value);

        previousCalculatorValue.value = '';
        operator.value = null;
      }
    }
    //   return {
    //   calculatorValue: '',
    //   calculatorElements: [7,8,9,'+',4,5,6,'-',1,2,3,'*',0,'.','=','/','C'],
    //   operator: null,
    //   previousCalculatorValue: '',
    // }
  
onUpdated(() => {
  console.log(calculatorValue.value);
})
</script>

<template>
  <!-- Happy Coding -->
  <div class="p-3" style="max-width: 400px; margin: 50px auto; background: #234">
    
    <!-- Calculator Result -->
    <div class="w-full rounded m-1 p-3 text-right lead font-weight-bold text-white bg-vue-dark">
      {{ calculatorValue || 0 }}
    </div>

    <!-- Calculator buttons -->
    <div class="row no-gutters">
      <div class="col-3" v-for="n in calculatorElements" :key="n">
        <div class="lead text-white text-center m-1 py-3 bg-vue-dark rounded hover-class"
          :class="{'bg-vue-green': ['C','*','/','-','+','%','='].includes(n)}"
          @click="action(n)"
        >
          {{n}}
        </div>
      </div>
    </div>

  </div>
   
</template>



<style scoped>
  .bg-vue-dark {
    background: #31475e;
  }
  .hover-class:hover {
    cursor: pointer;
    background: #3D5875;
  }
  .bg-vue-green {
    background: #3fb984;
  }

  .p-3 {
    max-width: 400px;
    margin: 50px auto; 
    background: #234;
  }
</style>