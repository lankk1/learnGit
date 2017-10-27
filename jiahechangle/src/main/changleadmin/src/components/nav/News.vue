<!-- 
  @user slipkinem
  @date 9/5/2017
  @license Copyright © 2016, PuKang Health Maintenance Co.
 -->
<template>
  <section>
    <el-row :gutter="20">
      <el-col :span="24" :offset="22">
        <el-button type="text" @click="insertClick">
          <i class="el-icon-plus"></i>新增
        </el-button>
      </el-col>
    </el-row>

    <template>
      <el-table
          :data="news.list"
          border
          algin="center"
          style="width: 100%">
        <el-table-column
            prop="newsId"
            label="ID"
            width="120"
            sortable
        ></el-table-column>

        <el-table-column
            prop="newsUrl"
            label="新闻图片"
            sortable
        ></el-table-column>

        <el-table-column
            prop="newsTitle"
            label="新闻标题"
            sortable
        ></el-table-column>

        <el-table-column
            prop="newsTitleEn"
            label="英文标题"
            sortable
        ></el-table-column>

        <el-table-column
            prop="newsSubtitle"
            label="新闻子标题"
            sortable
        ></el-table-column>

        <el-table-column
            prop="newsSubtitleEn"
            label="英文子标题"
            sortable
        ></el-table-column>

        <el-table-column
            prop="newsContent"
            label="新闻内容"
            sortable
        ></el-table-column>

        <el-table-column
            prop="newsContentEn"
            label="英文内容"
            sortable
        ></el-table-column>


        <el-table-column
            inline-template
            :context="_self"
            label="操作"
        >
            <span>
                <el-button @click="editClick($index, row)" type="text" size="small">编辑</el-button>
                <el-button @click="deleteNews(row)" type="text" size="small">删除</el-button>
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
          :total="news.total">
      </el-pagination>
    </div>

    <!--edit form-->
    <el-dialog :title="dialogTitle" v-model="dialogFormVisible">
      <el-row :gutter="20">
        <el-form :span="24">
          <el-form-item>
            <el-input class="dander-input" auto-complete="off" value="注意，如果有换行的地方加上 '<br/>' 标识符"
                      :disabled="true"></el-input>
          </el-form-item>
        </el-form>
      </el-row>

      <el-form :model="formData" :rules="rules" ref="formData">

        <el-form-item label="新闻标题" :label-width="'120px'" prop="newsTitle">
          <el-input auto-complete="off" v-model="formData.newsTitle"></el-input>
        </el-form-item>

        <el-form-item label="英文标题" :label-width="'120px'" prop="newsTitleEn">
          <el-input auto-complete="off" v-model="formData.newsTitleEn"></el-input>
        </el-form-item>

        <el-form-item label="新闻子标题" :label-width="'120px'" prop="newsSubtitle">
          <el-input auto-complete="off" v-model="formData.newsSubtitle"></el-input>
        </el-form-item>

        <el-form-item label="英文子标题" :label-width="'120px'" prop="newsSubtitleEn">
          <el-input auto-complete="off" v-model="formData.newsSubtitleEn"></el-input>
        </el-form-item>

        <el-form-item label="产品图片" :label-width="'120px'" prop="productImg">
          <el-upload
              ref="upload"
              action="/api/news/upload"
              :multiple="false"
              :auto-upload="false"
              :on-change="handleChange"
              :data="formData"
              :on-success="handleSuccess"
          >
            <el-button slot="trigger" size="small" type="primary">选择文件</el-button>
          </el-upload>
        </el-form-item>

        <el-form-item label="新闻内容" :label-width="'120px'" prop="newsContent">
          <el-input type="textarea" auto-complete="off" v-model="formData.newsContent"></el-input>
        </el-form-item>

        <el-form-item label="英文内容" :label-width="'120px'" prop="newsContentEn">
          <el-input type="textarea" auto-complete="off" v-model="formData.newsContentEn"></el-input>
        </el-form-item>

      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button @click="cancelDialog" type="info">取 消</el-button>
        <el-button @click="closeDialog" type="primary">确 定</el-button>
      </div>
    </el-dialog>

  </section>
</template>

<script>
  import { mapState, mapActions } from 'vuex'
  import { Message } from 'element-ui'

  export default {
    data () {
      return {
        fileList: [],
        page: {
          pageNum: 1,
          pageSize: 10
        },
        formData: {
          newsTitle: '',
          newsTitleEn: '',
          newsSubtitleEn: '',
          newsSubtitle: '',
          newsContentEn: '',
          newsContent: ''
        },
        rules: {
          newsTitle: [{
            required: true, message: '请输入名称', trigger: 'blur'
          }],
          newsTitleEn: [{
            required: true, trigger: 'blur'
          }],
          newsSubtitleEn: [{
            required: true, message: '请输入名称', trigger: 'blur'
          }],
          newsSubtitle: [{
            required: true, trigger: 'blur'
          }],
          newsContentEn: [{
            required: true, trigger: 'blur'
          }],
          newsContent: [{
            required: true, trigger: 'blur'
          }]
        },
        dialogFormVisible: false,
        dialogType: '',
        dialogTitle: '',
        pickerOptions: {
          shortcuts: [
            {
              text: '今天',
              onClick (picker) {
                picker.$emit('pick', new Date())
              }
            }, {
              text: '昨天',
              onClick (picker) {
                const date = new Date()
                date.setTime(date.getTime() - 3600 * 1000 * 24)
                picker.$emit('pick', date)
              }
            }, {
              text: '一周前',
              onClick (picker) {
                const date = new Date()
                date.setTime(date.getTime() - 3600 * 1000 * 24 * 7)
                picker.$emit('pick', date)
              }
            }
          ]
        }
      }
    },
    computed: {
      ...mapState(['news'])
    },
    created () {
      this.getNews(this.page)
    },
    methods: {
      ...mapActions(['getNews', 'deleteNews', 'editNews', 'insertData']),
      editClick ($index, row) {
        this.dialogType = 'edit'
        this.dialogTitle = '编辑数据'
        this.formData = Object.assign({}, row)
        this.dialogFormVisible = true
      },
      insertClick () {
        this.dialogType = 'insert'
        this.dialogTitle = '添加新闻'
        this.formData = {
          newsTitle: '',
          newsTitleEn: '',
          newsSubtitleEn: '',
          newsSubtitle: '',
          newsContentEn: '',
          newsContent: ''
        }
        this.dialogFormVisible = true
      },
      cancelDialog () {
        this.dialogFormVisible = false
        this.$refs.upload.clearFiles()
      },
      closeDialog () {
        console.log(this.$refs['formData'])
        this.$refs['formData'].validate((valid) => {
          if (!valid) return false

          if (this.dialogType === 'edit') {
            if (this.fileList.length > 0) {
              this.uploadImg()
            } else {
              this.editNews(this.formData)
              this.cancelDialog()
            }
          }

          if (this.dialogType === 'insert') {
            if (this.fileList.length < 1) {
              Message.error('请选择图片！')
            } else {
              this.uploadImg()
            }
          }
        })
      },
      handleSizeChange (val) {
        this.page.pageSize = val
        this.page.pageNum = 1
        this.getNews(this.page)
        console.log(`每页 ${val} 条`)
      },
      handleCurrentChange (val) {
        this.page.pageNum = val
        this.getNews(this.page)
        console.log(`当前页是: ${val}`)
      },
      uploadImg () {
        this.$refs.upload.submit()
      },
      handleChange (file, fileList) {
        if (fileList.length > 1) {
          fileList.splice(0, 1)
        }
        this.fileList = fileList
      },
      handleSuccess (res, file) {
        Message.success('操作成功')
        this.cancelDialog()
        this.getNews(this.page)
      }
    }
  }
</script>

<style lang="scss" rel="stylesheet/scss" scoped>
  .block {
    margin-top: 20px;
    margin-left: 30px;
    position: relative;
  }
  .dander-input input {
    color: #ff0000 !important;
  }
</style>
