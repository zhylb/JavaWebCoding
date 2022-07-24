
function delFruit(fid){
    if(confirm("是否要删除？")){
        window.location.href = "fruit.do?operate=delete&fid="+fid;
    }
}

function page(pageNo){
    window.location.href = "fruit.do?pageNo="+pageNo;
}