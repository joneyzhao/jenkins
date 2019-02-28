import Vue from 'vue'
import Counter from '@/components/Counter'

let vm
beforeEach(function () {
  const constructor = Vue.extend(Counter)
  vm = new constructor().$mount()
})

describe('Counter.vue', () => {
  it('title should is Hello unit test', () => {
    // 断言组件的title是否为'Hello unit test'
    expect(vm.title).to.equal('Hello unit test')
  })
  it('upperCase From Hello unit test convert to HELLO UNIT TEST', () => {
    // vue 组件export出来的是个对象，直接用这个对象的属性和方发就能调用到要测试的filter
    let str = Counter.filters.upperCase('Hello unit test')
    // 断言组件的title经过upperCase转换后是'HELLO UNIT TEST'
    expect(str).to.equal('HELLO UNIT TEST')
  })
  it('when type is A return Apple', () => {
    // 断言组件tyep为A的时候值为Apple
    // expect(vm.$el.querySelector('.selectA').textContent).to.equal('Apple')
    expect(vm.$el.querySelector('.selectA').textContent).to.equal('Apple')
  })
  it('when type is B return Bable', () => {
    // 断言组件tyep为B的时候值为Bable 
    expect(vm.$el.querySelector('.selectB').textContent).to.equal('Bable')
  })
  it('changeType from !A to A or A to !A ', () => {
    // 点击之前
    let preType = vm.type
    // 调用实例中的changeType方法
    vm.changeType()
    // 点击之后
    // console.log('zhh--- type：' + vm.type)
    expect(vm.type).to.not.equal(preType)
  })
  it('after click, count will add 1', () => {
    // 获取button
    const button = vm.$el.querySelector('.increment')
    console.log(button)
    // 新建点击事件
    const clickEvent = new window.Event('click')
    // 触发点击事件
    button.dispatchEvent(clickEvent)
    // 监听点击事件
    vm._watcher.run()
    // 断言:count的值应该是数字1
    expect(Number(vm.$el.querySelector('.increment').textContent)).to.equal(1)
  })
  it('incrementByAsync, count will add 1', (done) => {
    // 获取button
    const button = vm.$el.querySelector('.incrementByAsync')
    console.log(button)
    // 新建点击事件
    const clickEvent = new window.Event('click')
    // 触发点击事件
    button.dispatchEvent(clickEvent)
    // 监听点击事件
    // vm._watcher.run()
    // 1s后进行断言
    window.setTimeout(() => {
      // 断言:count的值应该是数字1
      expect(Number(vm.$el.querySelector('.incrementByAsync').textContent)).to.equal(1)
      done()
    }, 1000)
  })
})
