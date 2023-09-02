package com.example.a10_scrolltabbar

class FifthFragment : MyFragment() {
    override fun getTabTitle(): String {
        return "Tab 5"
    }

    override fun getLayoutResourceId(): Int {
        return R.layout.fragment_fifth // FirstFragment에 해당하는 XML 레이아웃 리소스 ID를 반환
    }
}
