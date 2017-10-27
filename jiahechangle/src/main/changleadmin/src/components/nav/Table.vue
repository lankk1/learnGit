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
          :data="tableData.products"
          border
          algin="center"
          style="width: 100%">
        <el-table-column
            prop="productId"
            label="ID"
            width="120"
            sortable
        ></el-table-column>

        <el-table-column
            prop="productName"
            label="产品名称"
            sortable
        ></el-table-column>

        <el-table-column
            prop="productNameEn"
            label="英文名称"
            sortable
        ></el-table-column>

        <el-table-column
            label="产品图片"
            sortable
        >
          <template scope="scope">
            <img :src="scope.row.productImg" alt="图片" style="height: 140px;width: 140px">
          </template>
        </el-table-column>

        <el-table-column
            prop="productDescription"
            label="产品描述"
            sortable
        ></el-table-column>

        <el-table-column
            prop="productDescriptionEn"
            label="英文描述"
            sortable
        ></el-table-column>

        <el-table-column
            inline-template
            :context="_self"
            label="操作"
        >
            <span>
                <el-button @click="editClick($index, row)" type="text" size="small">编辑</el-button>
                <el-button @click="deleteData(row)" type="text" size="small">删除</el-button>
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
          :total="tableData.total">
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

        <!--<el-form-item label="日期" :label-width="'120px'" prop="date">-->
        <!--<el-date-picker-->
        <!--v-model="formData.date"-->
        <!--type="date"-->
        <!--align="right"-->
        <!--:picker-options="pickerOptions"-->
        <!--placeholder="选择日期">-->
        <!--</el-date-picker>-->
        <!--</el-form-item>-->

        <el-form-item label="产品名称" :label-width="'120px'" prop="productName">
          <el-input auto-complete="off" v-model="formData.productName"></el-input>
        </el-form-item>

        <el-form-item label="英文名称" :label-width="'120px'" prop="productNameEn">
          <el-input auto-complete="off" v-model="formData.productNameEn"></el-input>
        </el-form-item>

        <!--<el-form-item label="产品图片" :label-width="'120px'" prop="productImg">-->
        <!--<el-input auto-complete="off" v-model="formData.productImg"></el-input>-->
        <!--</el-form-item>-->

        <el-form-item label="产品图片" :label-width="'120px'" prop="productImg">
          <el-upload
              ref="productUpload"
              action="/api/product/upload"
              :multiple="false"
              :auto-upload="false"
              :on-change="handleChange"
              :data="formData"
              :on-success="handleSuccess"
          >
            <el-button slot="trigger" size="small" type="primary">选择文件</el-button>
          </el-upload>
        </el-form-item>

        <el-form-item label="产品描述" :label-width="'120px'" prop="productDescription">
          <el-input type="textarea" auto-complete="off" v-model="formData.productDescription"></el-input>
        </el-form-item>

        <el-form-item label="英文描述" :label-width="'120px'" prop="productDescriptionEn">
          <el-input type="textarea" auto-complete="off" v-model="formData.productDescriptionEn"></el-input>
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
          productImg: '',
          productName: '',
          productDescription: '',
          productNameEn: '',
          productDescriptionEn: ''
        },
        rules: {
          productName: [{
            required: true, message: '请输入名称', trigger: 'blur'
          }],
          productDescription: [{
            required: true, trigger: 'blur'
          }],
          productNameEn: [{
            required: true, message: '请输入名称', trigger: 'blur'
          }],
          productDescriptionEn: [{
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
      ...mapState(['tableData'])
    },
    created () {
      this.getTableData(this.page)
    },
    methods: {
      ...mapActions(['getTableData', 'deleteData', 'editData', 'insertData']),
      editClick ($index, row) {
        this.dialogType = 'edit'
        this.dialogTitle = '编辑数据'
        this.formData = Object.assign({}, row)
        this.dialogFormVisible = true
      },
      insertClick () {
        this.dialogType = 'insert'
        this.dialogTitle = '添加数据'
        this.formData = {
          productImg: '',
          productName: '',
          productDescription: '',
          productNameEn: '',
          productDescriptionEn: ''
        }
        this.dialogFormVisible = true
      },
      cancelDialog () {
        this.dialogFormVisible = false
        this.$refs.productUpload.clearFiles()
      },
      closeDialog () {
        console.log(this.$refs['formData'])
        this.$refs['formData'].validate((valid) => {
          if (!valid) return false

          if (this.dialogType === 'edit') {
            if (this.fileList.length > 0) {
              this.uploadImg()
            } else {
              this.editData(this.formData)
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
        this.getTableData(this.page)
        console.log(`每页 ${val} 条`)
      },
      handleCurrentChange (val) {
        this.page.pageNum = val
        this.getTableData(this.page)
        console.log(`当前页是: ${val}`)
      },
      uploadImg () {
        this.$refs.productUpload.submit()
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
        this.getTableData(this.page)
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

  .dander-input input {
    color: #ff0000 !important;
  }
</style>