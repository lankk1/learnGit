<template>
  <section>

    <template>
      <el-table
        :data="messageData.comments"
        border
        algin="center"
        style="width: 100%">
        <el-table-column
          prop="commentId"
          label="ID"
          width="80"
          sortable
        ></el-table-column>
        <el-table-column
          prop="date"
          label="时间"
          width="120"
          sortable
        >
        </el-table-column>
        <el-table-column
          prop="commentUser"
          label="留言人"
          width="150"
          sortable
        >
        </el-table-column>
        <el-table-column
          prop="commentAddress"
          label="所在地区"
          sortable
        >
        </el-table-column>
        <el-table-column
          prop="commentEmail"
          label="邮箱"
          sortable
        >
        </el-table-column>
        <el-table-column
          prop="commentTel"
          label="联系电话"
          sortable
        >
        </el-table-column>
        <el-table-column
          prop="commentContent"
          label="留言内容"
          sortable
        >
        </el-table-column>
        <el-table-column
          inline-template
          :context="_self"
          label="操作"
        >
            <span>
                <el-button @click="deleteMessageData(row)" type="text" size="small">删除</el-button>
            </span>
        </el-table-column>
      </el-table>
    </template>
    <div class="block">
      <el-pagination
        @size-change="handleSizeChange"
        @current-change="handleCurrentChange"
        :current-page="page.pageNum"
        :page-sizes="[10, 20, 30, 40]"
        :page-size="page.pageSize"
        layout="total, sizes, prev, pager, next, jumper"
        :total="messageData.total">
      </el-pagination>
    </div>
  </section>
</template>
<script>
  import {mapState, mapActions} from 'vuex'

  export default {
    data () {
      return {
        page: {
          pageNum: 1,
          pageSize: 10
        },
        formData: {
          commentId: '',
          date: '',
          commentUser: '',
          commentAddress: '',
          commentEmail: '',
          commentTel: '',
          commentContent: ''
        }
      }
    },
    computed: {
      ...mapState(['messageData'])
    },
    created () {
      this.getMessageData(this.page)
      console.log('kaishi ')
    },
    methods: {
      ...mapActions(['getMessageData', 'deleteMessageData']),
      handleSizeChange (val) {
        this.page.pageSize = val
        this.page.pageNum = 1
        this.getMessageData(this.page)
        console.log(`每页 ${val} 条`)
      },
      handleCurrentChange (val) {
        this.page.pageNum = val
        this.getMessageData(this.page)
        console.log(`当前页是: ${val}`)
      }
    }
  }
</script>
<style>
  .block {
    margin-top: 20px;
    margin-left: 30px;
    position: relative;
  }
</style>
