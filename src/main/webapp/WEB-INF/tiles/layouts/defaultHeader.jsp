<div class="top">
	<div class="container">
		<div class="row">
			<div class="span6">
				<p class="topcontact">
					<i class="icon-phone"></i> +91 98989 25458
				</p>
			</div>
			<div class="span6">
				<p class="topcontact" style="float:right">
					<i class="icon-user"></i>&nbsp; ${pageContext.request.userPrincipal.name}
					
					<a>Logout</a>
				</p>

			</div>
		</div>
	</div>
</div>
<div class="container">


	<div class="row nomargin">
		<div class="span4">
			<div class="logo">
				<a href="${pageContext.request.contextPath}/home"><img src="img/logo.png" alt="" /></a>
			</div>
		</div>
		<div class="span8">
			<div class="navbar navbar-static-top">
				<div class="navigation">
					<nav>
						<ul class="nav topnav">
							<li class="dropdown active">
								<a href="${pageContext.request.contextPath}/home">
									<i class="icon-home"></i> Home <i class="icon-angle-down"></i>
								</a>
								<ul class="dropdown-menu">
									<li><a href="${pageContext.request.contextPath}/signup">Sign Up</a></li>
									<li><a href="${pageContext.request.contextPath}/login" >Log In</a></li>
								</ul>
							</li>
							<li><a href="#">Features</a></li>
							<li><a href="#">Pages</a></li>
							<li><a href="contact.jsp">Contact </a></li>
						</ul>
					</nav>
				</div>
				<!-- end navigation -->
			</div>
		</div>
	</div>
</div>