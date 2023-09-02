package com.example.a10_scrolltabbar

class ThirdFragment : MyFragment() {
    override fun getTabTitle(): String {
        return "Tab 3"
    }

    override fun getLayoutResourceId(): Int {
        return R.layout.fragment_third // FirstFragment에 해당하는 XML 레이아웃 리소스 ID를 반환
    }
}
