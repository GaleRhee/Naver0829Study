//객체, 객체를 함수의 인자로 넘길 경우
let obj1={"name":"lee","addr":"seoul","age":20};
console.log(obj1.name);
console.log(obj1.addr);
console.log(obj1.age);

//ES6 의 방식으로 이름과 주소를 얻어서 출력하고자 할 경우
let {name, age}=obj1; //{} 안의 변수명은 반드시 객체의 키값과 동일해야 한다
console.log(name); //name 변수명은 나중에 인식이 안될 수도 있기에 다른 것으로 바꿔 쓰는 것을 추천한다
console.log(age);

let f1=({name,addr})=>{
    console.log("이름="+name);
    console.log("주소는="+addr);
}
//호출
f1(obj1);