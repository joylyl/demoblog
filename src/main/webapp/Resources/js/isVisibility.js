/**
 * Created by 刘印龙 on 2015/7/1.
 * 判断元素是否在浏览器可见区域
 */
function visibility(obj){
    var pos = obj.getBoundingClientRect();
    // 判断是否在可视区,这里只判断了高度是否在可视区
    if(pos.top>0&&window.innerHeight-pos.top>pos.height){
        return true;
    }else{
        return false;
    }
}