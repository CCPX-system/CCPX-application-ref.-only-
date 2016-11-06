<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html >
<html>
<head><H1>CCPX Project</H1>
</head>

<body>
<form method="post" action="checkSeller" id="loginForm">
						<h2>login</h2>
						<p>please login here</p>
						<ul class="form-list">
							<li>
								<label class="required" for="email">用户名<em>*</em></label>
								<div class="input-box">
									
								<input type="text" name="username" id="username" tabindex="1" autocomplete="off" class="input-text required-entry validate-email" />
								</div>
								<div class="clear"></div>
							</li>
							<li>
								<label class="required" for="pass">密码<em>*</em></label>
								<div class="input-box">
									<input type="password" name="password"
					maxlength="16" id="password" tabindex="2" class="input-text required-entry validate-password"/>
							
								</div>
								<div class="clear"></div>
							</li>
							<li>
							
								<label class="required" for="pass">验证码<em>*</em></label>
				 <input type="text" name="verifyCode"
					maxlength="4" id="verifyCode" tabindex="3"  class="input-text required-entry validate-email"  />
				<div class="codeImg">
					
						<a href="javascript:_hyz()"><img id="imgVerifyCode"
							src="verifyCode" /> </a>
				</div>
							
							</li>
						</ul>
						<p class="required" id="verifyCodeError">* ${msg}</p>
					</div>
					<div class="buttons-set">
				,<!-- 	<a class="f-left" href="#">Forgot Your Password?</a>   -->	
						<input type="submit" tabindex="5" class="colors-btn" class="colors-btn"  title="Login" value="登录" />

						
						<div class="clear"></div>
					</div>
            	</div>
            		</form>
          		<!--  -->	  	
            	
   
            	
            	
            	
				<div class="clear"></div>
			</div>
		</div>
		<div class="clearfix"></div>

	</div>
</section>
</div>
</body>
</html>



