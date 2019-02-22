
import Vue from 'vue'
import child from '@/components/child/child'

/**
 * 获取生成的vm
Component 组件
propsData props数据
 */
function getRenderedVm (Component, propsData) {
  const Constructor = Vue.extend(Component)
  const vm = new Constructor({ propsData }).$mount()
  return vm
}

// 描述要测试的内容
describe('test child.vue', () => {
  // 描述要测试的最小单元
  it('child组件的message应该是 This is child vue!', () => {
    let childvm = getRenderedVm(child, {
      message: 'This is child vue!'
    })
    // 断言组件的child组件的props是否生效
    expect(childvm.message).to.equal('This is child vue!')
  })
})
