import { PageHeader } from 'antd';
import React from "react";
import style from "./Header.css"
const Header = ({title,subTitle}) =>{
  return(
    <PageHeader
      className={style.sitePageHeader}
      title={title}
      subTitle={subTitle}
    />
  )
}
export default Header;
