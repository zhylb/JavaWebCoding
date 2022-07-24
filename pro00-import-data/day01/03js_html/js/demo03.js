window.onload = function () {
    updateAllCount();
    //当页面加载完成 绑定各种事件
    //根据id获取到标签
    let fruitTbl = document.getElementById("tbl_fruit");
    //获取表格中所有的行
    let rows = fruitTbl.rows;
    for (let i = 1; i < rows.length -1; i++) {
        var tr = rows[i];
        //1 绑定鼠标悬浮设置背景颜色事件
        tr.onmouseover = showBGColor;
        tr.onmouseout = clearBGColor;

        var cells = tr.cells;
        var priceId = cells[1];
        var numTD = cells[2];
        priceId.onmouseover = showHand;
        numTD.onmouseover = showHand;
        //3 绑定鼠标单机单元格的事件
        priceId.onclick = editPrice;
        numTD.onclick = editPrice;
    }
}


function editPrice() {
    if(event && event.srcElement && event.srcElement.tagName==="TD"){
        var priceTD = event.srcElement;
        //判断当前节点有子节点 而且第一个子节点是文本节点 textNode = 3,ElementNode = 1
        if(priceTD.firstChild && priceTD.firstChild.nodeType==3){
            var oldPrice = priceTD.innerText;
            //设置当前节点的内部HTML
            priceTD.innerHTML="<input type='text' size='3'/>";

            var input = priceTD.firstChild;
            if(input.tagName==="INPUT"){
                input.value = oldPrice;
                //选中输入框内部的文本
                input.select();
                //4 绑定输入框失去焦点事件 更新单件
                input.onblur = updatePrice;

            }
        }

    }
}

function updatePrice() {
    if(event && event.srcElement && event.srcElement.tagName=="INPUT"){
        var input = event.srcElement;
        var newPrice =  input.value;
        //input的父节点 td
        var priceTD = input.parentElement;

        priceTD.innerText = newPrice;

        //更新当前行的值 td的父元素是tr
        updateCount(priceTD.parentElement);

    }
}

//更新指定行
function updateCount(tr) {
    if(tr && tr.tagName=="TR"){
        var tds = tr.cells;
        var price = tds[1].innerText;
        var num = tds[2].innerText;

        var count = parseInt(price) * parseInt(num);
        tds[3].innerText = count;

        updateAllCount();
    }
}

function updateAllCount() {
    var fruitTbl = document.getElementById("tbl_fruit")

    if(fruitTbl && fruitTbl.tagName=="TABLE"){

        let trs = fruitTbl.rows;
        var sum = 0;
        for (let i = 1; i < trs.length - 1; i++) {
            sum =  sum + parseInt(trs[i].cells[3].innerText);
        }
        // lastTd = trs[trs.length -1];
        // alert(lastTd[1]);
        trs[trs.length - 1].cells[1].innerText = sum;
    }


}


//当鼠标悬浮时 显示背景颜色
function showBGColor() {
    //event 当前发生的事件
    //event.srcElement 事件源

    // alert(event.srcElement)
    // alert(event.srcElement.tagName)
    if(event && event.srcElement.tagName){
        var td = event.srcElement;
        //td.parentElement获取td父元素 -》 tr
        var tr = td.parentElement;
        //如果想要设置某节点的样式 则需要 .style
        tr.style.backgroundColor = "red"
        //表示获取这个tr所有的单元格
        var tds = tr.cells;
        for (let i = 0; i < tds.length; i++) {
            tds[i].style.color="white";
        }
    }
}

//当鼠标离开时 恢复原始的注释
function clearBGColor() {
    if(event && event.srcElement.tagName){
        var td = event.srcElement;
        //td.parentElement获取td父元素 -》 tr
        var tr = td.parentElement;
        //如果想要设置某节点的样式 则需要 .style
        tr.style.backgroundColor = "transparent"
        //表示获取这个tr所有的单元格
        var tds = tr.cells;
        for (let i = 0; i < tds.length; i++) {
            tds[i].style.color="midnightblue";
        }
    }
}

//当鼠标悬浮在单件单元时 显示手势
function showHand() {
    if(event && event.srcElement && event.srcElement.tagName == "TD"){
        var td = event.srcElement;
        td.style.cursor  = "hand";
    }
}