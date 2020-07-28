import { Form, Input, Button, Checkbox } from 'antd';
import React from "react";
import cookie from 'react-cookies';
const layout = {
  labelCol: { span: 6 },
  wrapperCol: { span: 16 },
};
const tailLayout = {
  wrapperCol: { offset: 4, span: 16 },
};

const LoginForm = () => {
  const onFinish = values => {
    console.log('Success:', values);
    let {remember,username,password} = values;
    let user = {
      username,
      password
    }
    let inFifteenMinutes = new Date(new Date().getTime() + 24 * 3600 * 1000);//一天
    if(remember===true){
      cookie.save("username",username,{expires:inFifteenMinutes });
      cookie.save("password",password,{expires:inFifteenMinutes});
    }

  };

  const onFinishFailed = errorInfo => {
    console.log('Failed:', errorInfo);
  };
  const initLoginInformation = {
      remember: true,
      username: cookie.load("username")||"",
      password: cookie.load("password")||"",
}
  return (
    <Form
      {...layout}
      name="basic"
      initialValues={initLoginInformation}
      onFinish={onFinish}
      onFinishFailed={onFinishFailed}
    >
      <Form.Item
        label="用户名"
        name="username"
        rules={[{ required: true, message: 'Please input your username!' }]}
      >
        <Input />
      </Form.Item>

      <Form.Item
        label="密码"
        name="password"
        rules={[{ required: true, message: 'Please input your password!' }]}
      >
        <Input.Password />
      </Form.Item>
      <Form.Item {...tailLayout}>
        <Form.Item  name="remember" valuePropName="checked" noStyle>
          <Checkbox>Remember me</Checkbox>
        </Form.Item>
        <a className="login-form-forgot" href="https://hkzhao123.github.io/">
          Forgot password
        </a>
      </Form.Item>
      <Form.Item {...tailLayout}>
        <Button  type="primary" htmlType="submit" block>
          登录
        </Button>
        Or <a href="https://hkzhao123.github.io/">register now!</a>
      </Form.Item>
    </Form>
  );
};
export default LoginForm;
