<template>
  <div class="container">
    <header>
    </header>

    <section>
      <el-form ref="form" :label-position="'top'" label-width="100px">
        <el-form-item label="用户名">
          <el-input v-model="user.userCode" placeholder="用户名"></el-input>
        </el-form-item>

        <el-form-item label="密码">
          <el-input v-model="user.userPassword" placeholder="密码" type="password"></el-input>
        </el-form-item>

        <el-form-item>
          <el-button nativeType="submit" type="success" @click.prevent="login">登录</el-button>
        </el-form-item>

      </el-form>
    </section>
    <footer></footer>
  </div>
</template>

<script>
  import { Message } from 'element-ui'

  export default {
    data () {
      return {
        user: {},
        imgCaptchaSrc: ''
      }
    },
    methods: {
      login () {
        this.$http.post('user/login', this.user)
          .then(response => {
            let responseBody = response.body
            if (responseBody.errorCode === 0) {
              Message.success('验证成功')
              this.$router.push({
                path: 'home/product'
              })
            } else {
              Message.error(responseBody.errorMessage)
            }
          })
      }
    }
  }
</script>

<style lang="scss" rel="stylesheet/scss">
  .container {
    header {
      padding-top: 100px;
    }

    section {
      width: 400px;
      margin: 0 auto;
    }

    footer {
      padding-bottom: 200px;
    }

  }
</style>