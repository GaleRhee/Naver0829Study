//펼침 연산자 ...
let arr1=[3,4,5];
let arr2=[6,7,8];
//arr3 에 arr1 과 arr2 의 값을 모두 넣고 싶을 경우
let arr3=[...arr1,...arr2,30,40];

//개수 출력
console.log("arr3="+arr3.length);
console.log(arr3);

let sum1=(a,b,c)=>a+b+c;

console.log(sum1(3,5,7));
console.log(sum1(...arr2));
console.log(sum1(...arr3)); //총 8개의 값 중 앞의 3개만 인자로 넘어간다