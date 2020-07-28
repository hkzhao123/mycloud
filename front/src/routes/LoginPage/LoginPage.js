import React from "react";
import Header from "../../components/Header";
import Footer from "../../components/Footer";
import LoginForm from "./LoginForm";
import style from "./LoginPage.css"



const LoginPage = () =>{
  return (
    <div>
      <Header title={"芜湖"} subTitle={"我的微服务前后端实现"}/>
      <div className={style.back} >
        <div className={style.loginForm}>
          <span className={style.loginText}>用户登录</span>
          <LoginForm />
        </div>
      </div>
      <Footer/>
    </div>
  )
}


export default LoginPage;
