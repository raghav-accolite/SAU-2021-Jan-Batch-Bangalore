function sum_digits(str) {
  var dsum = 0;

  for (var i = 0; i < str.length; i++)
  {
    if (/[0-9]/.test(str[i])) dsum += parseInt(str[i])
  }
  return dsum;
}
console.log(sum_digits("1234getonthedancefloor"));
