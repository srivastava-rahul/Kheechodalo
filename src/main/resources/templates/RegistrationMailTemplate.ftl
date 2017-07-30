<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Email</title>
<style>
.email_bttn {
	width: 100%;
	float: left;
	border: 1px solid #0095d5;
	text-align: center;
	font-size: 16px;
	color: #0095d5;
	text-decoration: none;
	padding: 15px 0
}

.email_bttn:hover {
	background: #0095d5;
	color: #fff;
}

.footer {
	text-align: center;
	color: #fff;
	font-size: 12px;
	line-height: 15px;
	padding: 13px 0
}

.help {
	text-align: center;
	color: #595959;
	font-size: 12px;
	line-height: 15px;
	padding: 8px 0;
	border-bottom: 5px solid #fff;
}

.help a {
	color: #0095d5;
	text-decoration: none
}

.help a:hover {
	color: #ffa019;
	text-decoration: none
}
</style>
</head>
<body style="font-family: Verdana, Geneva, sans-serif;">
	<table width="600" border="0" cellspacing="0" cellpadding="0" style="border: 1px solid #a1d0e4;">
		<tr>
			<td style="background: #0095d5;">
				<table width="96%" border="0" cellspacing="0" cellpadding="0" style="margin: 0 2%">
					<tr>
						<td>
							<table width="100%" border="0" cellspacing="0" cellpadding="0">
								<tr>
									<td style="font-size: 13px; color: #fff; padding: 10px 0">
										<!-- <a href="#" style="color:#fff; text-decoration:none;">View in Browser</a> -->
									</td>
									<td style="font-size: 13px; color: #fff; padding: 10px 0; text-align: right"></td>
								</tr>
							</table>
						</td>
					</tr>
				</table>
			</td>
		</tr>
		<tr>
			<td>
				<table width="96%" border="0" cellspacing="0" cellpadding="0" style="margin: 0 2%">
					<tr>
						<td style="font-size: 15px; padding: 30px 0 30px 0; color: #525252; line-height: 21px; text-align: left;">
							<h3>Hi ${userName}</h3>
							${message}
						</td>
					</tr>
				</table>
			</td>
		</tr>
		<tr>
			<td>
				<table width="96%" border="0" cellspacing="0" cellpadding="0" style="margin: 0 2%">
					<tr>
						<td style="width: 20%">&nbsp;</td>
						<td style="padding: 0 0 30px 0">
							<a class="email_bttn" href="${appUrl}">CLICK HERE</a>
						</td>
						<td style="width: 20%">&nbsp;</td>
					</tr>
				</table>
			</td>
		</tr>
		<tr>
			<td>
				<table width="96%" border="0" cellspacing="0" cellpadding="0" style="margin: 0 2%">
					<tr>
						<td style="padding: 0 0 30px 0; font-size: 12px; color: #525252; line-height: 21px; text-align: left;">
							If the button appears to be broken, please copy and paste this link into a web browser window:
							<a href="${appUrl}" style="word-break: break-all; font-size: 8px;"> ${appUrl} </a>
						</td>
					</tr>
				</table>
			</td>
		</tr>
		<tr>
			<td style="padding: 0 0 30px 0">
				<table width="96%" border="0" cellspacing="0" cellpadding="0" style="margin: 0 2%">
					<tr>
						<td style="font-size: 15px; color: #525252; line-height: 21px; text-align: left;">
							Welcome to KheechoDalo.<br />
							<br /> All the best,<br />KheechoDalo Team
						</td>
					</tr>
				</table>
			</td>
		</tr>
		<tr>
			<td style="background: #f0f0f0">
				<table width="96%" border="0" cellspacing="0" cellpadding="0" style="margin: 0 2%">
					<tr>
						<td class="help" style="text-align: left;">
							If you need assistance or have questions, please contact
							<a href="#">Customer Service</a>
							or you can manage your
							<a href="${loginUrl}">account here</a>
						</td>
					</tr>
				</table>
			</td>
		</tr>
		<tr>
			<td style="background: #0095d5">
				<table width="96%" border="0" cellspacing="0" cellpadding="0" style="margin: 0 2%">
					<tr>
						<td class="footer">
							&copy; 2017 KheechoDalo, India
						</td>
					</tr>
				</table>
			</td>
		</tr>
	</table>
</body>
</html>
