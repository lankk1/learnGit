/**
 * Created by slipkinem on 2016/12/9.
 */
'use strict'
import * as types from './mutation-types'
export default {
  [types.GET_TABLEDATA] (state, tableData) {
    state.tableData = tableData
  },
  [types.GET_MESSAGEDATA] (state, messageData) {
    state.messageData = messageData
  },
  [types.GET_NEWS] (state, o) {
    state.news.list = o.news
    state.news.total = o.total
  }
}
