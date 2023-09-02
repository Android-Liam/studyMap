package com.example.a10_scrolltabbar

class FourthFragment : MyFragment() {
    override fun getTabTitle(): String {
        return "Tab 4"
    }

    override fun getLayoutResourceId(): Int {
        return R.layout.fragment_fourth // FirstFragment에 해당하는 XML 레이아웃 리소스 ID를 반환
    }
}
