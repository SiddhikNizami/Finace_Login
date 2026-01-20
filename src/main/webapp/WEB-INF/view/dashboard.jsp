<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Dashboard - Finance Tracker</title>

    <style>
        body {
            margin: 0;
            font-family: Arial, sans-serif;
            background: #f4f4f4;
        }
        .header {
            background: #2e86de;
            padding: 15px;
            color: white;
            font-size: 22px;
        }
        .content {
            width: 90%;
            margin: 20px auto;
        }
        .card {
            background: white;
            padding: 20px;
            width: 30%;
            display: inline-block;
            box-shadow: 0 0 10px #aaa;
            border-radius: 10px;
            margin: 10px;
        }
        .title { font-size: 18px; color: #555; }
        .value { font-size: 26px; font-weight: bold; margin-top: 10px; }

        table {
            width: 100%;
            border-collapse: collapse;
            background: #fff;
            margin-top: 20px;
            box-shadow: 0 0 10px #aaa;
        }
        th, td {
            border: 1px solid #ccc;
            padding: 12px;
            text-align: center;
        }
        th {
            background: #2e86de;
            color: white;
        }

        .logout-btn {
            float: right;
            background: #ff4444;
            padding: 8px 12px;
            border-radius: 6px;
            text-decoration: none;
            color: white;
        }
    </style>
</head>

<body>

<div class="header">
    Welcome, ${user.fullName}
    <a href="logout" class="logout-btn">Logout</a>
</div>

<div class="content">

    <!-- CARDS -->
    <div class="card">
        <div class="title">Total Income</div>
        <div class="value">₹ ${totalIncome}</div>
    </div>

    <div class="card">
        <div class="title">Total Expense</div>
        <div class="value">₹ ${totalExpense}</div>
    </div>

    <div class="card">
        <div class="title">Balance</div>
        <div class="value">₹ ${balance}</div>
    </div>


    <!-- TABLE: RECENT TRANSACTIONS -->
    <h2>Recent Transactions - ${currentMonth} ${currentYear}</h2>

    <table>
        <thead>
        <tr>
            <th>Date</th>
            <th>Type</th>
            <th>Amount (₹)</th>
            <th>Category</th>
            <th>Description</th>
        </tr>
        </thead>

        <tbody>
        <c:forEach var="t" items="${recentTransactions}">
            <tr>
                <td>${t.transactionDate}</td>
                <td>${t.type}</td>
                <td>${t.amount}</td>
                <td>${t.category.name}</td>
                <td>${t.description}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>

</div>

</body>
</html>
