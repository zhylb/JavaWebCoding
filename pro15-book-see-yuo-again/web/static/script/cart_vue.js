
window.onload = function (){
    let vue = new Vue({
        el:"#w_vue",

        data:{
            cart:{}
        },

        methods:{
            getCart:function () {
                axios({
                    method:"POST",
                    url:"cart.do",
                    params:{
                        operate:"getCart",
                    }
                }).
                then(function (value) {
                    let data = value.data;
                    vue.cart = data;
                }).
                catch(function (reason) {
                    
                })
                
            },

            updateCart:function (id,num,bookId){
                axios({
                    method:"POST",
                    url:"cart.do",
                    params:{
                        operate:"updateCart",
                        id:id,
                        num:num,
                        bookId:bookId,
                    }
                }).
                then(function (value) {
                    let data = value.data;
                    vue.cart = data;
                }).
                catch(function (reason) {

                })
            }
        },

        mounted : function (){
            this.getCart();
        }
    })



}