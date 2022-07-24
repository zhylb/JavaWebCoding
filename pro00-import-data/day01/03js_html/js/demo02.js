
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